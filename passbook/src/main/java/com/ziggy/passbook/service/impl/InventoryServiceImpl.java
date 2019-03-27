package com.ziggy.passbook.service.impl;

import com.spring4all.spring.boot.starter.hbase.api.HbaseTemplate;
import com.ziggy.passbook.constant.Constants;
import com.ziggy.passbook.dao.MerchantsDao;
import com.ziggy.passbook.entity.Merchants;
import com.ziggy.passbook.mapper.PassTemplateRowMapper;
import com.ziggy.passbook.service.IIventoryService;
import com.ziggy.passbook.service.IUserPassService;
import com.ziggy.passbook.utils.RowKeyGenUtil;
import com.ziggy.passbook.vo.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.filter.CompareFilter;
import org.apache.hadoop.hbase.filter.FilterList;
import org.apache.hadoop.hbase.filter.LongComparator;
import org.apache.hadoop.hbase.filter.SingleColumnValueFilter;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Description: 获取库存信息, 只返回用户没有领取的
 * @Param:
 * @return:
 * @Author: Ziggy
 * @Date: 2019/3/18
 */

@Slf4j
@Service
public class InventoryServiceImpl implements IIventoryService {
    private final MerchantsDao merchantsDao;

    private final HbaseTemplate hbaseTemplate;

    private final IUserPassService userPassService;

    @Autowired
    public InventoryServiceImpl(HbaseTemplate hbaseTemplate, MerchantsDao merchantsDao, IUserPassService userPassService) {
        this.hbaseTemplate = hbaseTemplate;
        this.merchantsDao = merchantsDao;
        this.userPassService = userPassService;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Response getInventoryInfo(Long userId) throws Exception {
        Response allUserPass = userPassService.getUserAllPassInfo(userId);
        List<PassInfo> passInfos = (List<PassInfo>) allUserPass.getData();

        List<PassTemplate> excludeObject = passInfos.stream().map(
            PassInfo::getPassTemplate
        ).collect(Collectors.toList());

        List<String> excludeIds = new ArrayList<>();
        excludeObject.forEach(e -> excludeIds.add(
                RowKeyGenUtil.genPassTemplateRowKey(e)
        ));

        return new Response(new InventoryResponse(userId,
                buildPassTemplateInfo(getAvailablePassTemplate(excludeIds))));
    }

    /**
     * @Description: 获取系统中可用的优惠券
     * @Param: [exludeIds] 需要排出的优惠券Ids
     * @return: java.util.List<com.ziggy.passbook.vo.PassTemplate>
     * @Author: Ziggy
     * @Date: 2019/3/18
     */
    private List<PassTemplate> getAvailablePassTemplate(List<String> exludeIds) {
        FilterList filterList = new FilterList(FilterList.Operator.MUST_PASS_ONE);
        filterList.addFilter(
                new SingleColumnValueFilter(
                        Bytes.toBytes(Constants.PassTemplateTable.FAMILY_C),
                        Bytes.toBytes(Constants.PassTemplateTable.LIMIT),
                        CompareFilter.CompareOp.GREATER,
                        new LongComparator(0L)
                )
        );
        filterList.addFilter(
                new SingleColumnValueFilter(
                        Bytes.toBytes(Constants.PassTemplateTable.FAMILY_C),
                        Bytes.toBytes(Constants.PassTemplateTable.LIMIT),
                        CompareFilter.CompareOp.EQUAL,
                        Bytes.toBytes(-1)
                )
        );
        Scan scan = new Scan();
        scan.setFilter(filterList);

        List<PassTemplate> validTemplates = hbaseTemplate.find(
                Constants.PassTemplateTable.TABLE_NAME,
                scan, new PassTemplateRowMapper()
        );

        List<PassTemplate> availablePassTemplates = new ArrayList<>();

        Date cur = new Date();

        for (PassTemplate validTemplate : validTemplates) {
            if (exludeIds.contains(RowKeyGenUtil.genPassTemplateRowKey(validTemplate)))
                continue;

            if (cur.getTime() >= validTemplate.getStart().getTime()
                    && cur.getTime() <= validTemplate.getEnd().getTime()) {
                availablePassTemplates.add(validTemplate);
            }
        }

        return availablePassTemplates;
    }

    /**
     * @Description: 构造优惠券信息
     * @Param: [availablePassTemplates]
     * @return: java.util.List<com.ziggy.passbook.vo.PassTemplateInfo>
     * @Author: Ziggy
     * @Date: 2019/3/20
     */
    private List<PassTemplateInfo> buildPassTemplateInfo(List<PassTemplate> passTemplates) {

        Map<Integer,Merchants> merchantsMap = new HashMap<>();
        List<Integer> merchantsIds = passTemplates.stream().map(
                PassTemplate::getId
        ).collect(Collectors.toList());

        List<Merchants> merchants = merchantsDao.findByIdIn(merchantsIds);
        merchants.forEach(m->merchantsMap.put(m.getId(),m));

        List<PassTemplateInfo> result = new ArrayList<>(passTemplates.size());
        for (PassTemplate passTemplate : passTemplates){
            Merchants mc = merchantsMap.getOrDefault(passTemplate.getId(),null);
            if (null == mc ){
                log.error("Merchants Error:{}",passTemplate.getId());
                continue;
            }

            result.add(new PassTemplateInfo(passTemplate,mc));
        }

        return  result;
    }

}

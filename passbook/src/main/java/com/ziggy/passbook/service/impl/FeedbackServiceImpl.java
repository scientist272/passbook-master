package com.ziggy.passbook.service.impl;

import com.alibaba.fastjson.JSON;
import com.spring4all.spring.boot.starter.hbase.api.HbaseTemplate;
import com.ziggy.passbook.constant.Constants;
import com.ziggy.passbook.mapper.FeedBackMapper;
import com.ziggy.passbook.service.IFeedbackService;
import com.ziggy.passbook.utils.RowKeyGenUtil;
import com.ziggy.passbook.vo.Feedback;
import com.ziggy.passbook.vo.Response;
import lombok.extern.slf4j.Slf4j;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.filter.PrefixFilter;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @Description: 评论功能实现
* @Param:
* @return:
* @Author: Ziggy
* @Date: 2019/3/15
*/
@Slf4j
@Service
public class FeedbackServiceImpl implements IFeedbackService {

    //HBase客户端
    private final HbaseTemplate hbaseTemplate;

    @Autowired
    public FeedbackServiceImpl(HbaseTemplate hbaseTemplate) {
        this.hbaseTemplate = hbaseTemplate;
    }

    @Override
    public Response createFeedback(Feedback feedback) {
        if(!feedback.validate()){
            log.error("Feedback Error:{}", JSON.toJSONString(feedback));
        }
        Put put = new Put(Bytes.toBytes(RowKeyGenUtil.genFeedbackRowKey(feedback)));


        put.addColumn(
                Bytes.toBytes(Constants.FeedBack.FAMILY_I),
                Bytes.toBytes(Constants.FeedBack.USER_ID),
                Bytes.toBytes(feedback.getUserId())
        );
        put.addColumn(
                Bytes.toBytes(Constants.FeedBack.FAMILY_I),
                Bytes.toBytes(Constants.FeedBack.TYPE),
                Bytes.toBytes(feedback.getType())
        );
        put.addColumn(
                Bytes.toBytes(Constants.FeedBack.FAMILY_I),
                Bytes.toBytes(Constants.FeedBack.TEMPLATE_ID),
                Bytes.toBytes(feedback.getTemplateId())
        );

        put.addColumn(
                Bytes.toBytes(Constants.FeedBack.FAMILY_I),
                Bytes.toBytes(Constants.FeedBack.COMMENT),
                Bytes.toBytes(feedback.getComment())
        );
        hbaseTemplate.saveOrUpdate(Constants.FeedBack.TABLE_NAME,put);
        return Response.success();
    }

    @Override
    public Response getFeedback(Long userId) {
        byte[] reverseUserId = new StringBuilder(String.valueOf(userId)).reverse().toString().getBytes();
        Scan scan = new Scan();
        scan.setFilter(new PrefixFilter(reverseUserId));

        List<Feedback> feedbacks = hbaseTemplate.find(Constants.FeedBack.TABLE_NAME,scan,new FeedBackMapper());
        return new Response(feedbacks);
    }
}

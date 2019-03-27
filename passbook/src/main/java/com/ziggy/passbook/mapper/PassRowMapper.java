package com.ziggy.passbook.mapper;

import com.spring4all.spring.boot.starter.hbase.api.RowMapper;
import com.ziggy.passbook.constant.Constants;
import com.ziggy.passbook.vo.Pass;
import org.apache.commons.lang.time.DateUtils;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;

/**
* @Description: Hbase Pass Row to Pass Object
* @Param:
* @return:
* @Author: Ziggy
* @Date: 2019/3/12
*/
public class PassRowMapper implements RowMapper<Pass>{

    private static byte[] FAMILY_I = Constants.PassTable.FAMILY_I.getBytes();
    private static byte[] USER_ID = Constants.PassTable.USER_ID.getBytes();
    private static byte[] TEMPLATE_ID = Constants.PassTable.TEMPLATE_ID.getBytes();
    private static byte[] TOKEN = Constants.PassTable.TOKEN.getBytes();
    private static byte[] ASSIGNED_DATE = Constants.PassTable.ASSIGNED_DATE.getBytes();
    private static byte[] CON_DATE = Constants.PassTable.CON_DATE.getBytes();


    @Override
    public Pass mapRow(Result result, int i) throws Exception {
        Pass pass = new Pass();
        pass.setUserId(Bytes.toLong(result.getValue(FAMILY_I,USER_ID)));
        pass.setTemplateId(Bytes.toString(result.getValue(FAMILY_I,TEMPLATE_ID)));
        pass.setToken(Bytes.toString(result.getValue(FAMILY_I,TOKEN)));

        String[] patterns = new String[] {"yyyy-MM-dd"};
        pass.setAssginedDate(DateUtils.parseDate(Bytes.toString(result.getValue(FAMILY_I,ASSIGNED_DATE)),patterns));

        String conDateStr = Bytes.toString(result.getValue(FAMILY_I,CON_DATE));
        if(conDateStr.equals("-1")){
            pass.setConDate(null);
        }else {
            pass.setConDate(DateUtils.parseDate(conDateStr,patterns));
        }

        pass.setRowKey(Bytes.toString(result.getRow()));
        return pass;
    }
}

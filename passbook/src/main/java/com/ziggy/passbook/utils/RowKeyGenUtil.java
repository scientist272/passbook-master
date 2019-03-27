package com.ziggy.passbook.utils;

import com.ziggy.passbook.vo.Feedback;
import com.ziggy.passbook.vo.GainPassTemplateRequest;
import com.ziggy.passbook.vo.PassTemplate;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;

/**
* @Description: RowKey生成器工具类
* @Param:
* @return:
* @Author: Ziggy
* @Date: 2019/3/13
*/
@Slf4j
public class RowKeyGenUtil {
    /**
    * @Description: 根据提供的passTemplate对象生成rowKey
    * @Param: [passTemplate]
    * @return: java.lang.String
    * @Author: Ziggy
    * @Date: 2019/3/13
    */
    public static String genPassTemplateRowKey(PassTemplate passTemplate){
        String passInfo = String.valueOf(passTemplate.getId()+"_"+passTemplate.getTitle());
        String rowKey = DigestUtils.md5Hex(passInfo);
        log.info("GenPassTemplateRowKey: {}, {}",passInfo,rowKey);
        return rowKey;
    }

    /**
    * @Description: 根据提供的领取优惠券请求生成rowKey，只可以在领取优惠券的时候使用
    * PassRowKey = reversed(userId) + inverse(timestamp) + PassTemplateRowKey
     * @Param: [request]
    * @return: java.lang.String
    * @Author: Ziggy
    * @Date: 2019/3/15
    */
    public static String genPassRowKey(GainPassTemplateRequest request){

        return new StringBuilder(String.valueOf(request.getUserId())).reverse().toString() +
                (Long.MAX_VALUE-System.currentTimeMillis()) +
                genPassTemplateRowKey(request.getPassTemplate());
    }


    /**
    * @Description: 根据feedback构造rowKey
    * @Param: [feedback]
    * @return: java.lang.String
    * @Author: Ziggy
    * @Date: 2019/3/13
    */
    public static String genFeedbackRowKey(Feedback feedback){
        return new StringBuilder(String.valueOf(feedback.getUserId())).reverse().toString() +
                (Long.MAX_VALUE-System.currentTimeMillis());
    }

}

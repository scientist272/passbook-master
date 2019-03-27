package com.ziggy.passbook.service;

import com.ziggy.passbook.vo.GainPassTemplateRequest;
import com.ziggy.passbook.vo.Response;

/**
* @Description: 用户领取优惠券功能实现
* @Param:
* @return:
* @Author: Ziggy
* @Date: 2019/3/15
*/
public interface IGainPassTemplateService {

    /**
    * @Description: 用户领取优惠券
    * @Param: [request]
    * @return: com.ziggy.passbook.vo.Response
    * @Author: Ziggy
    * @Date: 2019/3/15
    */
    Response gainPassTemplate(GainPassTemplateRequest request) throws Exception;
}

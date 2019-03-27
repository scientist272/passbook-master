package com.ziggy.passbook.merchants.service;


import com.ziggy.passbook.merchants.vo.CreateMerchantsRequest;
import com.ziggy.passbook.merchants.vo.PassTemplate;
import com.ziggy.passbook.merchants.vo.Response;

//对商户服务接口的定义
public interface IMerchantsServ {

    //创建商户服务
    Response createMerchants(CreateMerchantsRequest request);

    //根据id构造商户信息
    Response buildMerchantsInfoById(Integer id);

    //投放优惠券
    Response dropPassTemplate(PassTemplate passTemplate);
}

package com.ziggy.passbook.service;

import com.ziggy.passbook.vo.Response;

/**
* @Description: 获取库存信息:只返回用户没有领取的，即优惠券库存功能实现接口定义
* @Param:
* @return:
* @Author: Ziggy
* @Date: 2019/3/15
*/
public interface IIventoryService {

    /**
    * @Description: 获取库存信息
    * @Param: [userId] 用户id
    * @return: com.ziggy.passbook.vo.Response
    * @Author: Ziggy
    * @Date: 2019/3/15
    */
    Response getInventoryInfo(Long userId) throws Exception;

}

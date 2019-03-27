package com.ziggy.passbook.service;

import com.ziggy.passbook.vo.Pass;
import com.ziggy.passbook.vo.Response;

/** 
* @Description: 获取用户个人优惠券信息 
* @Param:  
* @return:  
* @Author: Ziggy
* @Date: 2019/3/15 
*/ 
public interface IUserPassService {
    /** 
    * @Description: 获取用户个人优惠券信息（当前情况下可以使用的优惠券），即我的优惠券功能实现 
    * @Param: [userId] 用户Id
    * @return: com.ziggy.passbook.vo.Response 
    * @Author: Ziggy
    * @Date: 2019/3/15 
    */ 
    Response getUserPassInfo(Long userId) throws Exception;
    
    /** 
    * @Description: 获取用户已经消费了的优惠券,即已使用的优惠券功能实现 
    * @Param: [userId] 用户Id
    * @return: com.ziggy.passbook.vo.Response 
    * @Author: Ziggy
    * @Date: 2019/3/15 
    */ 
    Response getUserUsedPassInfo(Long userId) throws Exception;
    
    /** 
    * @Description:  获取用户所有的优惠券
    * @Param: [userId] 用户Id
    * @return: com.ziggy.passbook.vo.Response 
    * @Author: Ziggy
    * @Date: 2019/3/15 
    */ 
    Response getUserAllPassInfo(Long userId) throws Exception;
    
    /** 
    * @Description: 用户使用优惠券 
    * @Param: [pass] 
    * @return: com.ziggy.passbook.vo.Response 
    * @Author: Ziggy
    * @Date: 2019/3/15 
    */ 
    Response userUserPass(Pass pass);
}


package com.ziggy.passbook.service;

import com.ziggy.passbook.vo.Response;
import com.ziggy.passbook.vo.User;

/**
* @Description: 用户服务:创建User服务
* @Param:
* @return:
* @Author: Ziggy
* @Date: 2019/3/14
*/
public interface IUserService {
    /**
    * @Description: 创建用户
    * @Param: [user]
    * @return: com.ziggy.passbook.vo.Response
    * @Author: Ziggy
    * @Date: 2019/3/14
    */
    Response createUser(User user) throws Exception;

}

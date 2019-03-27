package com.ziggy.passbook.service;

import com.ziggy.passbook.vo.Feedback;
import com.ziggy.passbook.vo.Response;

/**
* @Description: 用户评论相关功能实现
* @Param:
* @return:
* @Author: Ziggy
* @Date: 2019/3/15
*/
public interface IFeedbackService {
    /**
    * @Description: 创建评论
    * @Param: [feedback]
    * @return: com.ziggy.passbook.vo.Response
    * @Author: Ziggy
    * @Date: 2019/3/15
    */
    Response createFeedback(Feedback feedback);

    /**
    * @Description: 获取用户评论
    * @Param: [userId] 用户Id
    * @return: com.ziggy.passbook.vo.Response
    * @Author: Ziggy
    * @Date: 2019/3/15
    */
    Response getFeedback(Long userId);
}

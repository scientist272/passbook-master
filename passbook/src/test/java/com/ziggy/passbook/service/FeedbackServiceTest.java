package com.ziggy.passbook.service;

import com.alibaba.fastjson.JSON;
import com.ziggy.passbook.constant.FeedbackType;
import com.ziggy.passbook.vo.Feedback;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//用户反馈服务测试
@RunWith(SpringRunner.class)
@SpringBootTest
public class FeedbackServiceTest extends AbstractServiceTest{

    @Autowired
    private IFeedbackService feedbackService;


    @Test
    public void testCreateFeedback() {

        Feedback appFeedback = new Feedback();
        appFeedback.setUserId(userId);
        appFeedback.setType(FeedbackType.APP.getCode());
        appFeedback.setTemplateId("-1");
        appFeedback.setComment("学习分布式卡包应用");

        System.out.println(
                JSON.toJSONString(
                        feedbackService.createFeedback(appFeedback)
                )
        );

        Feedback passFeedback = new Feedback();
        passFeedback.setUserId(userId);
        passFeedback.setType(FeedbackType.PASS.getCode());
        passFeedback.setTemplateId("5aac4065ebd6667b05422217e67d1be5");
        passFeedback.setComment("优惠券评论");

        System.out.println(
                JSON.toJSONString(
                        feedbackService.createFeedback(passFeedback)
                )
        );
    //{"errorCode":0,"errorMsg":""}
        //   {"errorCode":0,"errorMsg":""}
    }



    /*
    {
    "data":[
        {
            "comment":"优惠券评论",
            "templateId":"5aac4065ebd6667b05422217e67d1be5",
            "type":"PASS",
            "userId":190770
        },
        {
            "comment":"学习分布式卡包应用",
            "templateId":"-1",
            "type":"APP",
            "userId":190770
        }
    ],
    "errorCode":0,
    "errorMsg":""
}
     */
    @Test
    public void testGetFeedback(){
        System.out.println(
                JSON.toJSONString(
                        feedbackService.getFeedback(userId)
                )
        );
    }
}

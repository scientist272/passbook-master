package com.ziggy.passbook.service;

//用户优惠券服务测试

import com.alibaba.fastjson.JSON;
import com.ziggy.passbook.vo.Pass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserPassServiceTest extends AbstractServiceTest {

    @Autowired
    private IUserPassService userPassService;

    @Test
    public void testGetUserPassInfo() throws Exception{
        System.out.println(
                JSON.toJSONString(
                        userPassService.getUserPassInfo(userId)
                )
        );
    }

    @Test
    public void testGetUserUsedPassInfo() throws Exception{
        System.out.println(
                JSON.toJSONString(
                        userPassService.getUserUsedPassInfo(userId)
                )
        );
    }

    /*
    {
    "data":[
        {
            "merchants":{
                "address":"北京市",
                "businessLicenseUrl":"www.imooc.com",
                "id":17,
                "isAudit":true,
                "logoUrl":"www.imooc.com",
                "name":"慕课",
                "phone":"1234567890"
            },
            "pass":{
                "assginedDate":1553529600000,
                "templateId":"faaa511241ee33a562a31082c4df7906",
                "token":"-1",
                "userId":190770
            },
            "passTemplate":{
                "background":2,
                "desc":"详情: 慕课",
                "end":1555171200000,
                "hasToken":false,
                "id":17,
                "limit":10000,
                "start":1551715200000,
                "summary":"简介: 慕课",
                "title":"title: 2"
            }
        },
        {
            "merchants":{
                "$ref":"$.data[0].merchants"
            },
            "pass":{
                "assginedDate":1553529600000,
                "templateId":"5aac4065ebd6667b05422217e67d1be5",
                "token":"token-1",
                "userId":190770
            },
            "passTemplate":{
                "background":2,
                "desc":"详情: 慕课",
                "end":1555171200000,
                "hasToken":true,
                "id":17,
                "limit":10000,
                "start":1551715200000,
                "summary":"简介: 慕课",
                "title":"title: 3"
            }
        }
    ],
    "errorCode":0,
    "errorMsg":""
}
     */
    @Test
    public void getUserAllPassInfo() throws Exception{
        System.out.println(
                JSON.toJSONString(
                        userPassService.getUserAllPassInfo(userId)
                )
        );
    }

    //{"errorCode":0,"errorMsg":""}
    @Test
    public void testUserUsePass() {
        Pass pass = new Pass();
        pass.setUserId(userId);
        pass.setTemplateId("5aac4065ebd6667b05422217e67d1be5");

        System.out.println(
                JSON.toJSONString(
                        userPassService.userUserPass(pass)
                )
        );
    }

}

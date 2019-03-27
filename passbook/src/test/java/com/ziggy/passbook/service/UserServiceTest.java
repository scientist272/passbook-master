package com.ziggy.passbook.service;

import com.alibaba.fastjson.JSON;
import com.ziggy.passbook.vo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//用户服务测试
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private IUserService userService;


    /*
    {
    "data":{"baseInfo":{"age":10,"name":"imooc","sex":"m"},
    "id":190770,
    "otherInfo":{"address":"北京市朝阳区","phone":"123456"}},
    "errorCode":0,"errorMsg":""}
     */

    @Test
    public void testCreateUser() throws Exception {
        User user = new User();
        user.setBaseInfo(
                new User.BaseInfo("imooc", 10, "m"));
        user.setOtherInfo(
                new User.OtherInfo("123456", "北京市朝阳区"));

        System.out.println(JSON.toJSONString(userService.createUser(user)));
    }






}

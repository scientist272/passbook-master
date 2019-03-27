package com.ziggy.passbook.service;

import com.alibaba.fastjson.JSON;
import com.ziggy.passbook.vo.GainPassTemplateRequest;
import com.ziggy.passbook.vo.PassTemplate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//用户领取优惠券功能测试
@RunWith(SpringRunner.class)
@SpringBootTest
public class GainPassTemplateServiceTest extends AbstractServiceTest{
    @Autowired
    private IGainPassTemplateService gainPassTemplateService;

    @Test
    public void testGainPassTemplate() throws Exception{
        PassTemplate target = new PassTemplate();
        target.setId(17);
        target.setTitle("title: 2");
        target.setHasToken(false);

        System.out.println(JSON.toJSONString(
                gainPassTemplateService.gainPassTemplate(
                        new GainPassTemplateRequest(userId,target)
                )
        ));
    }
}

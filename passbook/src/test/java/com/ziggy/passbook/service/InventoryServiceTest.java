package com.ziggy.passbook.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
* @Description: 库存服务测试
* @Param:
* @return:
* @Author: Ziggy
* @Date: 2019/3/26
*/
@RunWith(SpringRunner.class)
@SpringBootTest
public class InventoryServiceTest extends AbstractServiceTest {

    @Autowired
    private IIventoryService iventoryService;

    /*
     测试结果见display.json
     */
    @Test
    public void testGetInventoryInfo() throws Exception{

        System.out.println(JSON.toJSONString(
                iventoryService.getInventoryInfo(userId),
                SerializerFeature.DisableCircularReferenceDetect
                ));
    }
}

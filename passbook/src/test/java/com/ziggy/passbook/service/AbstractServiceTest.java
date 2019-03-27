package com.ziggy.passbook.service;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
* @Description: 服务测试抽象基类
* @Param:
* @return:
* @Author: Ziggy
* @Date: 2019/3/26
*/
@RunWith(SpringRunner.class)
@SpringBootTest
public abstract class AbstractServiceTest {
    Long userId;

    @Before
    public void init(){
        userId = 190770L;
    }

}

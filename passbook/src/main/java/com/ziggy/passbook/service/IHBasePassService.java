package com.ziggy.passbook.service;

import com.ziggy.passbook.vo.PassTemplate;

/**
* @Description: Pass Hbase服务
* @Param:
* @return:
* @Author: Ziggy
* @Date: 2019/3/13
*/
public interface IHBasePassService {
    /**
    * @Description: 将PassTemplate写入HBase
    * @Param: [passTemplate]
    * @return: boolean
    * @Author: Ziggy
    * @Date: 2019/3/13
    */
    boolean dropPassTemplateToHBase(PassTemplate passTemplate);


}

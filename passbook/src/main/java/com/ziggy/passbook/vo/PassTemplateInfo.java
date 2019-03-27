package com.ziggy.passbook.vo;

import com.ziggy.passbook.entity.Merchants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
* @Description: 优惠券模板信息
* @Param:
* @return:
* @Author: Ziggy
* @Date: 2019/3/15
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PassTemplateInfo{
    //优惠券模板
    private PassTemplate passTemplate;

    //优惠券对应的商户
    private Merchants merchants;
}

package com.ziggy.passbook.vo;

import com.ziggy.passbook.entity.Merchants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @Description: 用户领取的优惠券信息
* @Param:
* @return:
* @Author: Ziggy
* @Date: 2019/3/15
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PassInfo {
    //优惠券
    private Pass pass;

    //优惠券模板
    private PassTemplate passTemplate;

    //优惠券对应的商户
    private Merchants merchants;
}

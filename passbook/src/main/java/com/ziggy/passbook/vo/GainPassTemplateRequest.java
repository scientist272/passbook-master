package com.ziggy.passbook.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @Description: 用户领取优惠券的请求对象
* @Param:
* @return:
* @Author: Ziggy
* @Date: 2019/3/15
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GainPassTemplateRequest {
    //用户Id
    private Long userId;

    //PassTemplate对象
    private PassTemplate passTemplate;
}

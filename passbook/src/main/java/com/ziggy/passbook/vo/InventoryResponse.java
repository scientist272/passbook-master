package com.ziggy.passbook.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
* @Description: 库存请求响应
* @Param:
* @return:
* @Author: Ziggy
* @Date: 2019/3/15
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryResponse {

    //用户Id
    private Long userId;

    //优惠券模板信息
    private List<PassTemplateInfo> passTemplateInfos;
}

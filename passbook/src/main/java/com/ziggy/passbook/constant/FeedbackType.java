package com.ziggy.passbook.constant;

import javax.persistence.criteria.CriteriaBuilder;

//评论类型枚举
public enum  FeedbackType {
    PASS("PASS","针对优惠券的评论"),
    APP("APP","针对卡包App的评论");

    //评论类型编码
    private String code;
    //评论类型描述
    private String desc;

    FeedbackType(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}

package com.ziggy.passbook.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//User Object
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    //用户id
    private Long id ;

    private BaseInfo baseInfo;

    private OtherInfo otherInfo;

    //用户基本信息
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BaseInfo{
        private String name;
        private Integer age;
        private String sex;
    }

    //用户额外信息
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class OtherInfo{
        private String phone;
        private String address;
    }
}

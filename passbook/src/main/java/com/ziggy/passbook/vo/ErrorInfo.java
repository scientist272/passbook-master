package com.ziggy.passbook.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @Description: 统一的错误信息
* @Param:
* @return:
* @Author: Ziggy
* @Date: 2019/3/13
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorInfo<T> {
    //错误码
    public static final Integer ERROR = -1;

    //特定错误码
    private Integer code;

    //错误信息
    private String message;

    //请求url
    private String url;

    //请求返回的数据
    private T data;
}

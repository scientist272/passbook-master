package com.ziggy.passbook.log;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
//日志对象
public class LogObject {
    //日志动作类型
    private String action;
    //用户id
    private Long userId;
    //当前时间戳
    private Long timestamp;
    //客户端ip地址
    private String remoteIp;
    //日志信息
    private Object info = null;
}

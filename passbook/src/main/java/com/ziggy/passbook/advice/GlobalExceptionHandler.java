package com.ziggy.passbook.advice;

import com.ziggy.passbook.vo.ErrorInfo;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
* @Description: 全局异常处理
* @Param:
* @return:
* @Author: Ziggy
* @Date: 2019/3/13
*/
@ControllerAdvice
public class GlobalExceptionHandler  {

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public ErrorInfo<String> errorHandler(HttpServletRequest request,Exception e){
        ErrorInfo<String> info = new ErrorInfo<>();

        info.setCode(ErrorInfo.ERROR);
        info.setMessage(e.getMessage());
        info.setData("Don't Have Return Data");
        info.setUrl(request.getRequestURL().toString());

        return info;
    }
}

package com.ziggy.passbook.controller;

import com.ziggy.passbook.log.LogConstants;
import com.ziggy.passbook.log.LogGenerator;
import com.ziggy.passbook.service.IUserService;
import com.ziggy.passbook.vo.Response;
import com.ziggy.passbook.vo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
* @Description: 创建用户服务
* @Param:
* @return:
* @Author: Ziggy
* @Date: 2019/3/24
*/
@Slf4j
@RestController
@RequestMapping("/passbook")
public class CreateUserController {

    //创建用户服务
    private final IUserService userService;

    //httpServletRequest
    private final HttpServletRequest httpServletRequest;



    @Autowired
    public CreateUserController(IUserService userService, HttpServletRequest httpServletRequest) {
        this.userService = userService;
        this.httpServletRequest = httpServletRequest;
    }

    /**
    * @Description: 创建用户
    * @Param: [user]
    * @return: com.ziggy.passbook.vo.Response
    * @Author: Ziggy
    * @Date: 2019/3/24
    */
    @ResponseBody
    @PostMapping("/createuser")
    Response createUser(@RequestBody User user) throws  Exception{
        LogGenerator.genLog(
                httpServletRequest,
                -1L,
                LogConstants.ActionName.CREATE_USER,
                user
        );
        return userService.createUser(user);
    }
}

package com.ziggy.passbook.controller;

import com.ziggy.passbook.constant.Constants;
import com.ziggy.passbook.log.LogConstants;
import com.ziggy.passbook.log.LogGenerator;
import com.ziggy.passbook.service.IFeedbackService;
import com.ziggy.passbook.service.IGainPassTemplateService;
import com.ziggy.passbook.service.IIventoryService;
import com.ziggy.passbook.service.IUserPassService;
import com.ziggy.passbook.vo.Feedback;
import com.ziggy.passbook.vo.GainPassTemplateRequest;
import com.ziggy.passbook.vo.Pass;
import com.ziggy.passbook.vo.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description: Passbook Rest Controller
 * @Param:
 * @return:
 * @Author: Ziggy
 * @Date: 2019/3/24
 */

@RestController
@Slf4j
@RequestMapping("/passbook")
public class PassbookController {

    //用户优惠券服务
    private final IUserPassService userPassService;

    //优惠券库存服务
    private final IIventoryService iventoryService;

    //领取优惠券服务
    private final IGainPassTemplateService gainPassTemplateService;

    //反馈服务
    private final IFeedbackService feedbackService;

    //HttpServletRequest
    private final HttpServletRequest httpServletRequest;

    @Autowired
    public PassbookController(IUserPassService userPassService,
                              IIventoryService iventoryService,
                              IGainPassTemplateService gainPassTemplateService,
                              IFeedbackService feedbackService,
                              HttpServletRequest httpServletRequest) {
        this.userPassService = userPassService;
        this.iventoryService = iventoryService;
        this.gainPassTemplateService = gainPassTemplateService;
        this.feedbackService = feedbackService;
        this.httpServletRequest = httpServletRequest;
    }

    /**
     * @Description: 获取用户个人的优惠券信息
     * @Param: [userId] 用户id
     * @return: com.ziggy.passbook.vo.Response
     * @Author: Ziggy
     * @Date: 2019/3/24
     */
    @ResponseBody
    @GetMapping("/userpassinfo")
    Response userPassInfo(Long userId) throws Exception {
        LogGenerator.genLog(
                httpServletRequest,
                userId,
                LogConstants.ActionName.USER_PASS_INFO,
                null
        );
        return userPassService.getUserPassInfo(userId);
    }

    /**
     * @Description: 获取用户使用了的优惠券信息
     * @Param: [userId] 用户id
     * @return: com.ziggy.passbook.vo.Response
     * @Author: Ziggy
     * @Date: 2019/3/24
     */
    @ResponseBody
    @GetMapping("/userusedpassinfo")
    Response userUsedPassInfo(Long userId) throws Exception {
        LogGenerator.genLog(
                httpServletRequest,
                userId,
                LogConstants.ActionName.USER_USERD_PASS_INFO,
                null
        );
        return userPassService.getUserUsedPassInfo(userId);
    }

    /**
     * @Description: 用户使用优惠券
     * @Param: [pass] 要使用的优惠券
     * @return: com.ziggy.passbook.vo.Response
     * @Author: Ziggy
     * @Date: 2019/3/24
     */
    @ResponseBody
    @PostMapping("/userusepass")
    Response userUsePass(@RequestBody Pass pass) {
        LogGenerator.genLog(
                httpServletRequest,
                pass.getUserId(),
                LogConstants.ActionName.USER_USE_PASS,
                pass
        );
        return userPassService.userUserPass(pass);
    }

    /**
     * @Description: 获取库存信息
     * @Param: [userId] 用户id
     * @return: com.ziggy.passbook.vo.Response
     * @Author: Ziggy
     * @Date: 2019/3/24
     */
    @ResponseBody
    @GetMapping("/inventoryinfo")
    Response inventoryInfo(Long userId) throws Exception {
        LogGenerator.genLog(
                httpServletRequest,
                userId,
                LogConstants.ActionName.INVENTORY_INFO,
                null
        );
        return iventoryService.getInventoryInfo(userId);
    }

    /**
    * @Description: 用户领取优惠券
    * @Param: [request]
    * @return: com.ziggy.passbook.vo.Response
    * @Author: Ziggy
    * @Date: 2019/3/24
    */
    @ResponseBody
    @PostMapping("/gainpasstemplate")
    Response gainPassTemplate(@RequestBody GainPassTemplateRequest request)
            throws Exception {
        LogGenerator.genLog(
                httpServletRequest,
                request.getUserId(),
                LogConstants.ActionName.GAIN_PASS_TEMPLATE,
                request
        );
        return gainPassTemplateService.gainPassTemplate(request);
    }

    /**
    * @Description: 用户创建评论
    * @Param: [feedback]
    * @return: com.ziggy.passbook.vo.Response
    * @Author: Ziggy
    * @Date: 2019/3/24
    */
    @ResponseBody
    @PostMapping("/createfeedback")
    Response createFeedback(@RequestBody Feedback feedback){
        LogGenerator.genLog(
                httpServletRequest,
                feedback.getUserId(),
                LogConstants.ActionName.CREATE_FEEDBACK,
                feedback
        );
      return feedbackService.createFeedback(feedback);
    }

    /**
    * @Description: 用户获取评论信息
    * @Param: [userId] 用户id
    * @return: com.ziggy.passbook.vo.Response
    * @Author: Ziggy
    * @Date: 2019/3/24
    */
    @ResponseBody
    @GetMapping("/getfeedback")
    Response getFeedback(Long userId){
        LogGenerator.genLog(
                httpServletRequest,
                userId,
                LogConstants.ActionName.GET_FEEDBACK,
                null
        );
        return feedbackService.getFeedback(userId);
    }

    /**
    * @Description: 异常演示接口
    * @Param: []
    * @return: com.ziggy.passbook.vo.Response
    * @Author: Ziggy
    * @Date: 2019/3/24
    */
    @ResponseBody
    @GetMapping("/exception")
    Response exception() throws Exception{
        throw new Exception("Welcome to passbook");
    }
}

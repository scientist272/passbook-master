package com.ziggy.passbook.merchants.controller;

/*
商户服务controller
 */

import com.alibaba.fastjson.JSON;
import com.ziggy.passbook.merchants.service.IMerchantsServ;
import com.ziggy.passbook.merchants.vo.CreateMerchantsRequest;
import com.ziggy.passbook.merchants.vo.PassTemplate;
import com.ziggy.passbook.merchants.vo.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/merchants")
public class MerchantsController {
    @Autowired
    private IMerchantsServ merchantsServ;

    @ResponseBody
    @PostMapping("/create")
    public Response createMerchants(@RequestBody CreateMerchantsRequest request){
        log.info("CreateMerchants: {}", JSON.toJSONString(request));
        return merchantsServ.createMerchants(request);
    }

    @ResponseBody
    @GetMapping("/{id}")
    public Response buildMerchantsInfo(@PathVariable Integer id){
        log.info("BuildMerchantsInfo: {}",id);
        return merchantsServ.buildMerchantsInfoById(id);
    }

    @ResponseBody
    @PostMapping("/drop")
    public Response dropPassTemplate(@RequestBody PassTemplate passTemplate){
        log.info("DropPassTemplate: {}",passTemplate);
        return merchantsServ.dropPassTemplate(passTemplate);
    }


}

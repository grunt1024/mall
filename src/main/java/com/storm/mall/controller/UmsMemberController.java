package com.storm.mall.controller;

import com.storm.mall.common.api.ApiResponse;
import com.storm.mall.common.api.ResultCode;
import com.storm.mall.service.UmsMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description
 * @Author ZhangHua
 * @CreateTime 2020-03-29 09:03
 */

@Api(tags = "UmsMemberController",description = "会员登录注册管理")
@RestController
@RequestMapping("/sso")
public class UmsMemberController {

    private final static Logger LOGGER = LoggerFactory.getLogger(UmsMemberController.class);

    @Autowired
    UmsMemberService umsMemberService;

    @ApiOperation("获取验证码")
    @GetMapping("/authcode")
    public ApiResponse getAuthCode(@RequestParam String telephone){
         String smsCode =  umsMemberService.generateAuthCode(telephone);
         LOGGER.info(telephone + "获取到的验证码" + smsCode);
        return new ApiResponse(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(),smsCode);
    }

    @ApiOperation("判断验证码是否正确")
    @PostMapping("/verifyAutoCode")
    @ResponseBody
    public ApiResponse updatePassword(@RequestParam String telephone,
                                       @RequestParam String authCode) {

        boolean result = umsMemberService.verifyAuthCode(telephone,authCode);
        if (result){
            return new ApiResponse(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(),null);
        }
        return new ApiResponse(ResultCode.FAILED.getCode(), ResultCode.FAILED.getMessage(),null);
    }
}

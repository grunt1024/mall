package com.storm.mall.controller;

import com.storm.mall.common.api.ApiResponse;
import com.storm.mall.common.api.BaseResponseData;
import com.storm.mall.mapper.UmsAdminMapper;
import com.storm.mall.service.UmsAdminService;
import com.storm.mall.util.JwtTokenUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

/**
 * @author : ZhangHua
 * @date : 2020/9/1 10:23
 * @description:
 * @version: V1.0.0
 */

@RestController
@Api("用户登录控制器")
@Slf4j
public class AuthController {

    @Autowired
    UmsAdminService umsAdminService;

    @Autowired
    AuthenticationManagerBuilder authenticationManagerBuilder;


    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtTokenUtil tokenUtil;

    @Autowired(required = false)
    UmsAdminMapper umsAdminMapper;

    @ApiOperation("登录接口")
    @PostMapping("admin/login")
    public ApiResponse login(@RequestBody Map<String,String> map){
        String username = map.get("username");
        String password = map.get("password");
        String token = umsAdminService.login(username,password);
        if (token == null){
            return new ApiResponse("用户名或者密码错误");
        }
        log.info("登录成功,token:{}",token);
        return new ApiResponse(token);
    }


    @GetMapping("admin/register")
    public BaseResponseData register(){
        return BaseResponseData.ofSuccess("register");
    }

    @PreAuthorize("hasRole('NORMAL')")
    @GetMapping("admin/userList")
    public ApiResponse test(){
        SecurityContext securityContext =   SecurityContextHolder.getContext();
        return new ApiResponse("用户列表");
    }


//    public static void main(String[] args) {
//        UserDetails;
//
//        UserDetailsService;
//
//
//        Authentication;
//
//
//
//        SecurityContext;
//
//
//
//        UsernamePasswordAuthenticationToken;
//
//        UsernamePasswordAuthenticationToken uptoken = new UsernamePasswordAuthenticationToken("username","password");
//
//
//        SecurityContextHolder.getContext().setAuthentication(uptoken);
//
//    }
}

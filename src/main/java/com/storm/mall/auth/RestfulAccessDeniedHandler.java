package com.storm.mall.auth;

import cn.hutool.json.JSONUtil;
import com.storm.mall.common.api.ApiResponse;
import com.sun.org.apache.xpath.internal.operations.String;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author : ZhangHua
 * @date : 2020/9/1 16:01
 * @description:  当访问接口没有权限时候,自定义返回结果
 * @version: V1.0.0
 */
@Component
public class RestfulAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e) throws IOException, ServletException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.getWriter().println(JSONUtil.parse(new ApiResponse("没有权限")));
        response.getWriter().flush();
    }



}

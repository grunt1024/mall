package com.storm.mall.service.impl;

import com.storm.mall.auth.MyUserDetails;
import com.storm.mall.auth.MyUserDetailsServiceImpl;
import com.storm.mall.entity.UmsAdmin;
import com.storm.mall.entity.UmsAdminExample;
import com.storm.mall.entity.UmsPermission;
import com.storm.mall.mapper.UmsAdminMapper;
import com.storm.mall.service.UmsAdminService;
import com.storm.mall.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : ZhangHua
 * @date : 2020/9/1 13:31
 * @description:
 * @version: V1.0.0
 */
@Service
public class UmsAdminServiceImpl implements UmsAdminService {

    @Autowired(required = false)
    UmsAdminMapper umsAdminMapper;

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @Autowired
    MyUserDetailsServiceImpl userDetailsService;


    @Override
    public String login(String username, String password) {
//        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
//        if (!password.equals(userDetails.getPassword())){
//            System.out.printf("密码错误");
//        }

        //会自动调用userdetail loadname方法
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username,password);
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);

        MyUserDetails userDetails =(MyUserDetails) userDetailsService.loadUserByUsername(username);

        return jwtTokenUtil.generateToken(userDetails);
    }


    @Override
    public UmsAdmin getAdminByUsername(String username) {
        UmsAdminExample example = new UmsAdminExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<UmsAdmin> list =  umsAdminMapper.selectByExample(example);
        return  list.size() > 0?list.get(0):null;
    }

    @Override
    public UmsAdmin register(UmsAdmin umsAdminParam) {
        umsAdminMapper.insert(umsAdminParam);
        return umsAdminParam;
    }

    @Override
    public List<UmsPermission> getPermissionList(Long adminId) {
        return null;
    }
}

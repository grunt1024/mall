package com.storm.mall.auth;

import com.storm.mall.entity.*;
import com.storm.mall.mapper.UmsAdminRoleRelationMapper;
import com.storm.mall.mapper.UmsRoleMapper;
import com.storm.mall.service.UmsAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : ZhangHua
 * @date : 2020/9/1 10:47
 * @description:
 * @version: V1.0.0
 */

@Service
public class MyUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UmsAdminService umsAdminService;

    @Autowired(required = false)
    UmsRoleMapper umsRoleMapper;

    @Autowired(required = false)
    UmsAdminRoleRelationMapper umsAdminRoleRelationMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UmsAdmin umsAdmin = umsAdminService.getAdminByUsername(username);
        if (umsAdmin == null){
            throw new UsernameNotFoundException("用户不存在");
        }
        MyUserDetails userDetails = new MyUserDetails();

        UmsAdminRoleRelationExample example = new UmsAdminRoleRelationExample();
        example.createCriteria().andAdminIdEqualTo(umsAdmin.getId());
        List<UmsAdminRoleRelation> list = umsAdminRoleRelationMapper.selectByExample(example);
        List<UmsRole> roles = new ArrayList<>();
        for (UmsAdminRoleRelation relation :list){
            UmsRole role = umsRoleMapper.selectByPrimaryKey(relation.getRoleId());
            roles.add(role);
        }
        userDetails.setUmsAdmin(umsAdmin);
        userDetails.setRoles(roles);
        return userDetails;
    }
}
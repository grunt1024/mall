package com.storm.mall.service;

import com.storm.mall.entity.UmsAdmin;
import com.storm.mall.entity.UmsPermission;

import java.util.List;

/**
 * @author : ZhangHua
 * @date : 2020/9/1 13:31
 * @description:
 * @version: V1.0.0
 */
public interface UmsAdminService {

    /**
     * 根据用户名获取后台管理员
     */
    UmsAdmin getAdminByUsername(String username);

    /**
     * 注册功能
     */
    UmsAdmin register(UmsAdmin umsAdminParam);


    /**
     * 登录功能
     * @param username 用户名
     * @param password 密码
     * @return 生成的JWT的token
     */
    String login(String username, String password);


    /**
     * 获取用户所有权限（包括角色权限和操作权限）
     */
    List<UmsPermission> getPermissionList(Long adminId);
}

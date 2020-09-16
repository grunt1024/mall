package com.storm.mall.auth;

import com.storm.mall.entity.UmsAdmin;
import com.storm.mall.entity.UmsRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author : ZhangHua
 * @date : 2020/9/1 19:11
 * @description:
 * @version: V1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyUserDetails implements UserDetails {

    private UmsAdmin umsAdmin;


    String username;  //用户名
    String password;  //密码

    boolean accountNonExpired;   //是否没过期
    boolean accountNonLocked;   //是否没被锁定
    boolean credentialsNonExpired;  //是否没过期
    boolean enabled;  //账号是否可用


    //角色集合
    List<UmsRole> roles;

    /**
     * 数据权限集合
     */
    List<String> datascope;

    Collection<? extends GrantedAuthority> authorities;  //用户的权限集合


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (UmsRole role : roles) {
            authorities.add( new SimpleGrantedAuthority( role.getName() ) );
        }
        return authorities;
    }


    @Override
    public String getUsername() {
        return umsAdmin.getUsername();
    }


}

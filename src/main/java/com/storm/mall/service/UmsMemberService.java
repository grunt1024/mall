package com.storm.mall.service;

/**
 * @Description
 * @Author ZhangHua
 * @CreateTime 2020-03-29 09:06
 */
public interface UmsMemberService {
    /**
     * 生成验证码
     * @param telephone
     */
    String  generateAuthCode(String telephone);


    /**
     * 验证码验证
     * @param telephone 手机号
     * @param authCode  验证码
     * @return
     */
    boolean verifyAuthCode(String telephone,String authCode);
}

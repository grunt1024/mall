package com.storm.mall.common.api;

import org.springframework.util.StringUtils;

/**
 * @author: henry
 * @date: 2020/6/16 15:37
 */
public enum BaseStatusEnum {
    /**
     * 操作成功
     */
    SUCCESS("00000", "成功"),
    /**
     * 操作失败
     */
    ERROR("00001", "操作失败"),

    /**
     * 退出成功！
     */
    LOGOUT("00200", "退出成功！"),

    /**
     * 请求异常！
     */
    BAD_REQUEST("00400", "请求异常！"),

    /**
     * 请先登录！
     */
    UN_AUTHORIZED("00401", "请先登录！"),

    /**
     * 参数不匹配！
     */
    PARAM_NOT_MATCH("00402", "参数不匹配！"),

    /**
     * 暂无权限访问！
     */
    ACCESS_DENIED("00403", "权限不足！"),

    /**
     * 请求不存在！
     */
    REQUEST_NOT_FOUND("00404", "请求不存在！"),

    /**
     * 请求方式不支持！
     */
    HTTP_BAD_METHOD("00405", "请求方式不支持！"),

    /**
     * 参数不能为空！
     */
    PARAM_NOT_NULL("00406", "参数不能为空！"),

    /**
     * 当前用户已被锁定，请联系管理员解锁！
     */
    USER_DISABLED("00407", "当前用户已被锁定，请联系管理员解锁！"),

    /**
     * 用户名或密码错误！
     */
    USERNAME_PASSWORD_ERROR("05001", "用户名或密码错误！"),

    /**
     * token 已过期，请重新登录！
     */
    TOKEN_EXPIRED("05002", "token 已过期，请重新登录！"),

    /**
     * token 解析失败，请尝试重新登录！
     */
    TOKEN_PARSE_ERROR("05003", "token 解析失败，请尝试重新登录！"),

    /**
     * 当前用户已在别处登录，请尝试更改密码或重新登录！
     */
    TOKEN_OUT_OF_CTRL("05004", "当前用户已在别处登录，请尝试更改密码或重新登录！"),

    /**
     * 无法手动踢出自己，请尝试退出登录操作！
     */
    KICK_OUT_SELF("05005", "无法手动踢出自己，请尝试退出登录操作！"),
    /**
     * 不支持的TOKEN！
     */
    TOKEN_UN_SUPPORTED("05006", "不支持的TOKEN！"),
    /**
     * TOKEN签名无效
     */
    TOKEN_SIGNATURE_VALID("05007", "TOKEN签名无效！"),
    ;


    /**
     * 带参构造
     *
     * @param code
     * @param message
     */
    BaseStatusEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 匹配枚举对象
     *
     * @param code
     * @return
     */
    public static BaseStatusEnum getStatusEnum(String code) {
        for (BaseStatusEnum baseStatusEnum : values()) {
            if (StringUtils.endsWithIgnoreCase(baseStatusEnum.getCode(), code) && StringUtils.startsWithIgnoreCase(baseStatusEnum.getCode(), code)) {
                return baseStatusEnum;
            }
        }
        return null;
    }

    /**
     * 异常编码
     */
    private String code;

    /**
     * 异常信息
     */
    private String message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

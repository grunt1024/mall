package com.storm.mall.common.api;

/**
 * @Description 自定义业务状态码 这里是业务状态码,不是 http 返回码
 * @Author ZhangHua
 * @CreateTime 2020-03-28 21:08
 */
public enum ResultCode implements BusinessCode {


    SUCCESS(200, "操作成功"),
    FAILED(500, "操作失败"),
    VALIDATE_FAILED(404, "参数检验失败"),
    UNAUTHORIZED(401, "暂未登录或token已经过期"),
    FORBIDDEN(403, "没有相关权限");
    private long code;
    private String message;

    private ResultCode(long code, String message) {
        this.code = code;
        this.message = message;
    }

    public long getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}

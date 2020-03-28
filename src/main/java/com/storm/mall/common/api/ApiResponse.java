package com.storm.mall.common.api;

/**
 * @Description 接口通用返回类
 * @Author ZhangHua
 * @CreateTime 2020-03-28 21:01
 */
public class ApiResponse{

    private long code;
    private String message;
    private Object data;

    public ApiResponse(){}

    public ApiResponse(long code,String message,Object data){
        this.code = code;
        this.message = message;
        this.data = data;
    }


    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}

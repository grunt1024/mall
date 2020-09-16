package com.storm.mall.common.api;


import com.github.pagehelper.PageInfo;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 统一返回格式
 *
 * @author: henry
 * @date: 2020/6/8 13:41
 */
@Data
@NoArgsConstructor
public class BaseResponseData {
    /**
     * 版本号
     */
    private String version = "v1.0";

    /**
     * 异常信息
     */
    private String message;

    /**
     * 返回状态
     */
    private String status;

    /**
     * 时间开销
     */
    private String costTime;

    /**
     * 返回对象
     */
    private Object value;

    /**
     * 分页信息
     */
    private PageInfo page;

    /**
     * 带参构造：分页参数、对象参数
     *
     * @param obj
     * @param page
     */
    public BaseResponseData(String status, Object obj, PageInfo page) {
        this.status = status;
        this.value = obj;
        this.page = page;
    }

    /**
     * 带参构造：异常编码、异常信息
     *
     * @param status
     * @param message
     */
    public BaseResponseData(String status, String message) {
        this.status = status;
        this.message = message;
    }

    /**
     * 成功返回对象
     *
     * @param obj
     * @return
     */
    public static BaseResponseData ofSuccess(Object obj) {
        return ofSuccess(obj, null);
    }

    /**
     * 成功返回对象和分页
     *
     * @param obj
     * @param page
     * @return
     */
    public static BaseResponseData ofSuccess(Object obj, PageInfo page) {
        return new BaseResponseData(BaseStatusEnum.SUCCESS.getCode(), obj, page);
    }

    /**
     * 失败返回错误信息
     *
     * @param message
     * @return
     */
    public static BaseResponseData ofMessage(String message) {
        return ofMessage(BaseStatusEnum.ERROR.getCode(), message);
    }

    /**
     * 失败返回错误码和错误信息
     *
     * @param status
     * @param message
     * @return
     */
    public static BaseResponseData ofMessage(String status, String message) {
        return new BaseResponseData(status, message);
    }
}

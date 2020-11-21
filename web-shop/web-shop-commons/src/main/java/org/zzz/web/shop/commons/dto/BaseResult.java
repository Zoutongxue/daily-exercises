package org.zzz.web.shop.commons.dto;

/**
 * dto 数据传输对象
 * BaseResult 结果集
 *  这个类用于 自定义返回结果集
 */

import java.io.Serializable;

public class BaseResult implements Serializable {
    //封装一下状态码，提取常量
    public static final int STATUS_SUCCESS = 200;
    public static final int STATUS_FAIL = 500;

    //状态码
    private int status;

    private String message;

    //提取方法，用到的次数至三则重构。
    private static BaseResult createResult(int statusSuccess, String message) {
        BaseResult baseResult = new BaseResult();
        baseResult.setStatus(statusSuccess);
        baseResult.setMessage(message);
        return baseResult;
    }

    public static BaseResult success() {
        return BaseResult.createResult(STATUS_SUCCESS, "成功");
    }

    //方法重载
    private static BaseResult success(String message) {
        //自定义的消息-message
        return BaseResult.createResult(STATUS_SUCCESS, message);
    }

    private static BaseResult fail() {
        return BaseResult.createResult(STATUS_FAIL, "失败");
    }

    //方法重载
    public static BaseResult fail(String message) {
        //自定义的消息-message
        return BaseResult.createResult(STATUS_FAIL, message);
    }

    //方法重载
    private static BaseResult fail(int status, String message) {
        //状态码不止一种。自定义的消息-message
        return BaseResult.createResult(status, message);
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }



}


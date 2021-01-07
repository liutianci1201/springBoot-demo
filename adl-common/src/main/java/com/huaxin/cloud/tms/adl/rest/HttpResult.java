package com.huaxin.cloud.tms.adl.rest;

import com.huaxin.cloud.tms.adl.enums.ResultCodeEnum;

import java.io.Serializable;

/**
 * <p>
 *     统一请求返回包装
 * </p>
 *
 * @author LiuTianci
 * @date 2021-01-06 15:51
 */
public class HttpResult<T> implements Serializable {
    /**
     * 是否响应成功
     */
    private Boolean success;
    /**
     * 响应状态码
     */
    private Integer code;
    /**
     * 响应数据
     */
    private T data;
    /**
     * 错误信息
     */
    private String msg;

    // 构造器开始
    /**
     * 无参构造器(构造器私有，外部不可以直接创建)
     */
    private HttpResult() {
        this.code = 10000;
        this.success = true;
    }
    /**
     * 有参构造器
     * @param obj
     */
    private HttpResult(T obj) {
        this.code = 10000;
        this.data = obj;
        this.success = true;
    }

    /**
     * 有参构造器
     * @param message
     */
    private HttpResult(String message) {
        this.code = 10000;
        this.msg = message;
        this.success = true;
    }

    /**
     * 有参构造器
     * @param resultCode
     */
    private HttpResult(ResultCodeEnum resultCode) {
        this.success = false;
        this.code = resultCode.getCode();
        this.msg = resultCode.getMessage();
    }

    private HttpResult(T data, Boolean success, Integer code, String msg) {
        this.data = data;
        this.success = success;
        this.code = code;
        this.msg = msg;
    }
    // 构造器结束

    /**
     * 通用返回成功（没有返回结果）
     * @param <T>
     * @return
     */
    public static<T> HttpResult<T> success(){
        return new HttpResult();
    }

    /**
     * 返回成功（有返回结果）
     * @param data
     * @param <T>
     * @return
     */
    public static<T> HttpResult<T> success(T data){
        return new HttpResult<T>(data);
    }

    /**
     * 返回成功（有返回结果）
     * @param message
     * @param <T>
     * @return
     */
    public static<T> HttpResult<T> successPutMessage(String message){
        return new HttpResult<T>(message);
    }

    /**
     * 带返回值及错误信息的结果
     * @param data
     * @param resultCode
     * @param msg
     * @param <T>
     * @return
     */
    public static <T> HttpResult<T> success(T data, Integer resultCode, String msg){
        return new HttpResult<>(data,true, resultCode, msg);
    }

    /**
     * 通用返回失败
     * @param resultCode
     * @param <T>
     * @return
     */
    public static<T> HttpResult<T> failure(ResultCodeEnum resultCode){
        return  new HttpResult<T>(resultCode);
    }

    /**
     * 带错误信息返回结果
     * @param resultCode
     * @param msg
     * @param <T>
     * @return
     */
    public static <T> HttpResult<T> failure(int resultCode, String msg){
        return new HttpResult<T>(null,false,resultCode,msg);
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "HttpResult{" +
                "success=" + success +
                ", code=" + code +
                ", data=" + data +
                ", message='" + msg + '\'' +
                '}';
    }
}

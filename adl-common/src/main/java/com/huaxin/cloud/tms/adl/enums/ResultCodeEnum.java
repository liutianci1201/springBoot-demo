package com.huaxin.cloud.tms.adl.enums;

/**
 * <p>
 *     状态码枚举
 * </p>
 *
 * @author LiuTianci
 * @date 2021-01-06 15:51
 */
public enum ResultCodeEnum {
    /**
     * 权限枚举
     */
    SUCCESS(200, "successful"),
    REDIRECT(301, "redirect"),
    NOT_FOUND(404, "not found"),
    SERVER_ERROR(10003,"系统错误"),
    NO_PERMISSION(10004, "无此操作权限"),
    FILE_PERMISSION(10005, "权限认证失败"),
    SESSION_FAILED(10006, "认证过期"),
    SESSION_UNKNOWN(10007, "未认证")
    ;


    /** 这里可以根据不同模块用不同的区级分开错误码，例如:  */

    // 1000～1999 区间表示基础模块错误
    // 2000～2999 区间表示销售模块错误
    // 3000～3999 区间表示采购模块错误


    ;
    /**
     * 响应状态码
     */
    private Integer code;
    /**
     * 响应信息
     */
    private String message;

    ResultCodeEnum(Integer code, String msg) {
        this.code = code;
        this.message = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}

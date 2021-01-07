package com.huaxin.cloud.tms.adl.exception;

/**
 * <p>
 *     异常统一处理
 * </p>
 *
 * @author LiuTianci
 * @date 2020-10-13 9:27
 */
public class HuaxinCloudException extends RuntimeException{
    private String code = "-1";
    private String detailMessage;

    public HuaxinCloudException(HuaxinCloudException.ExceptionCode exceptionCode, String msg) {
        super(exceptionCode.getDesc());
        this.code = exceptionCode.getValue();
        this.detailMessage = msg;
    }

    public HuaxinCloudException(String code, String msg) {
        super(msg);
        this.code = code;
        this.detailMessage = msg;
    }

    public HuaxinCloudException(String msg) {
        super(msg);
        this.detailMessage = msg;
    }

    public HuaxinCloudException() {
    }

    public HuaxinCloudException(Exception e) {
        super(HuaxinCloudException.ExceptionCode.EXCEPTION.getDesc(), e);
        this.code = HuaxinCloudException.ExceptionCode.EXCEPTION.getValue();
        this.detailMessage = e.getMessage();
    }

    public String getCode() {
        return this.code;
    }

    public String getDetailMessage() {
        return this.detailMessage;
    }

    public static enum ExceptionCode {
        /**
         * 参数校验错误
         */
        VALIDATE("VALIDATE", "参数校验错误"),
        /**
         * 系统错误
         */
        EXCEPTION("EXCEPTION", "系统错误");

        private String value;
        private String desc;

        private ExceptionCode(String value, String desc) {
            this.value = value;
            this.desc = desc;
        }

        public static HuaxinCloudException.ExceptionCode getByValue(String value) {
            HuaxinCloudException.ExceptionCode[] var1 = values();
            int var2 = var1.length;

            for(int var3 = 0; var3 < var2; ++var3) {
                HuaxinCloudException.ExceptionCode e = var1[var3];
                if (e.value.equals(value)) {
                    return e;
                }
            }

            return null;
        }

        public String getValue() {
            return this.value;
        }

        public String getDesc() {
            return this.desc;
        }
    }
}

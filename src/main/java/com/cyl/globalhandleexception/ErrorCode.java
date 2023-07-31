package com.cyl.globalhandleexception;

public enum ErrorCode {

    SUCCESS(0, "成功"),

    SYSTEM_ERROR(10000, "系统异常， 请稍后重试");

    private Integer code;

    private String message;

    ErrorCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }
}

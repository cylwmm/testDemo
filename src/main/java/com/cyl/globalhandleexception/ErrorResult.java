package com.cyl.globalhandleexception;

import com.google.common.base.Throwables;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ErrorResult {
    private Integer status;
    private String message;
    private String exception;
    private String errors;

    public static ErrorResult fail(ErrorCode errorCode, Throwable e, String message) {
        ErrorResult result = ErrorResult.fail(errorCode, e);
        result.setMessage(message);
        return result;
    }
    public static ErrorResult fail(ErrorCode errorCode, Throwable e) {
        ErrorResult result = new ErrorResult();
        result.setMessage(errorCode.message());
        result.setStatus(errorCode.code());
        result.setException(e.getClass().getName());
        result.setErrors(Throwables.getStackTraceAsString(e));
        return result;
    }
}

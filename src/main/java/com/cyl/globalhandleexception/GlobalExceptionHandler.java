package com.cyl.globalhandleexception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Throwable.class)
    public ErrorResult handleThrowable(Throwable e, HttpServletRequest request) {
        ErrorResult error = ErrorResult.fail(ErrorCode.SYSTEM_ERROR, e);
        log.error("URL:{}, 系统异常", request.getRequestURI(), e);
        return error;
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(BusinessException.class)
    public ErrorResult handleThrowable(BusinessException e, HttpServletRequest request) {
        ErrorResult error = ErrorResult
                .builder()
                .status(e.getCode())
                .message(e.getMessage())
                .exception(e.getClass().getName())
                .build();
        log.error("URL:{}, 系统异常", request.getRequestURI(), e);
        return error;
    }
}

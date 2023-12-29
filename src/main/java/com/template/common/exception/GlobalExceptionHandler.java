package com.template.common.exception;

import com.template.common.ResultEnum;
import com.template.common.resp.CommonResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public CommonResponse BusinessExceptionHandler(BusinessException e) {
        log.error(e.getMessage());
        return CommonResponse.fail(e);
    }

    @ExceptionHandler(Exception.class)
    public CommonResponse ExceptionHandler(Exception e) {
        log.error(e.getMessage());
        return CommonResponse.fail(ResultEnum.ERROR);
    }
}
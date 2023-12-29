package com.template.common.exception;

import com.template.common.BaseResult;
import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {

    private final int code;

    public BusinessException(BaseResult baseResult) {
        super(baseResult.getMsg());
        this.code = baseResult.getCode();
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
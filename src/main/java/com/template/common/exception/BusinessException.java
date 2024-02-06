package com.template.common.exception;

import com.template.common.resp.BaseResult;
import lombok.Getter;

import java.text.MessageFormat;

@Getter
public class BusinessException extends RuntimeException {

    private final int code;

    public BusinessException(BaseResult baseResult) {
        super(baseResult.getMsg());
        this.code = baseResult.getCode();
    }

    public BusinessException(BaseResult baseResult, Object... params) {
        super(MessageFormat.format(baseResult.getMsg(), params));
        this.code = baseResult.getCode();
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}

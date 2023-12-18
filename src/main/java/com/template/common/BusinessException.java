package com.template.common;

import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {

    private Integer code;

    public BusinessException(BaseResult baseResult) {
        super(baseResult.getMsg());
        this.code = baseResult.getCode();
    }
}

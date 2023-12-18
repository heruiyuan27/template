package com.template.common;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public enum ResultEnum implements BaseResult {
    SUCCESS(0, "success"),
    ERROR(4000, "fail");

    private Integer code;
    private String msg;

    @Override
    public Integer getCode() {
        return this.code;
    }

    @Override
    public String getMsg() {
        return this.msg;
    }
}


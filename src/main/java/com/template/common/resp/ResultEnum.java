package com.template.common.resp;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public enum ResultEnum implements BaseResult {

    SUCCESS(0, "success"),
    ERROR(4000, "fail"),
    PARAM_ERROR_TEMPLATE(4001, "name:{0},age:{1},error");

    private int code;
    private String msg;

    @Override
    public int getCode() {
        return this.code;
    }

    @Override
    public String getMsg() {
        return this.msg;
    }

}


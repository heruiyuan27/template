package com.template.common.resp;

import lombok.*;

@Getter
@Setter
public class BaseResponse {
    protected int code;
    protected String msg;
}

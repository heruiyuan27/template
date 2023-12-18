package com.template.common;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Response<T> extends CommonResponse {

    private T data;

    public Response success() {
        Response<Object> oResponse = new Response<>();
        oResponse.setCode(ResultEnum.SUCCESS.getCode());
        oResponse.setMsg(ResultEnum.SUCCESS.getMsg());
        return oResponse;
    }

    public Response<T> success(T data) {
        Response<T> tResponse = new Response<>();
        tResponse.setData(data);
        tResponse.setCode(ResultEnum.SUCCESS.getCode());
        tResponse.setMsg(ResultEnum.SUCCESS.getMsg());
        return tResponse;
    }

    public Response fail(BaseResult baseResult) {
        Response<Object> oResponse = new Response<>();
        oResponse.setCode(baseResult.getCode());
        oResponse.setMsg(baseResult.getMsg());
        return oResponse;
    }

    public Response fail(BusinessException e) {
        Response<Object> oResponse = new Response<>();
        oResponse.setCode(e.getCode());
        oResponse.setMsg(e.getMessage());
        return oResponse;
    }
}

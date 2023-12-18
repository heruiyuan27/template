package com.template.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Response<T> extends CommonResponse {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    public static <T> Response<T> success() {
        Response<T> response = new Response<>();
        response.setCode(ResultEnum.SUCCESS.getCode());
        response.setMsg(ResultEnum.SUCCESS.getMsg());
        return response;
    }

    public static <T> Response<T> success(T data) {
        Response<T> response = new Response<>();
        response.setData(data);
        response.setCode(ResultEnum.SUCCESS.getCode());
        response.setMsg(ResultEnum.SUCCESS.getMsg());
        return response;
    }

    public static <T> Response<T> fail(BaseResult baseResult) {
        Response<T> response = new Response<>();
        response.setCode(baseResult.getCode());
        response.setMsg(baseResult.getMsg());
        return response;
    }

    public static <T> Response<T> fail(BusinessException e) {
        Response<T> response = new Response<>();
        response.setCode(e.getCode());
        response.setMsg(e.getMessage());
        return response;
    }
}

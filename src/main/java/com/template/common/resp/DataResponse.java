package com.template.common.resp;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.template.common.ResultEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DataResponse<T> extends BaseResponse {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    public static <T> DataResponse<T> success(T data) {
        DataResponse<T> dataResponse = new DataResponse<>();
        dataResponse.setCode(ResultEnum.SUCCESS.getCode());
        dataResponse.setMsg(ResultEnum.SUCCESS.getMsg());
        dataResponse.setData(data);
        return dataResponse;
    }
}

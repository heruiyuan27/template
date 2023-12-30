package com.template.common.resp;

import com.template.common.exception.BusinessException;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommonResponse extends BaseResponse {
    public static CommonResponse success() {
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setCode(ResultEnum.SUCCESS.getCode());
        commonResponse.setMsg(ResultEnum.SUCCESS.getMsg());
        return commonResponse;
    }

    public static CommonResponse fail(BaseResult baseResult) {
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setCode(baseResult.getCode());
        commonResponse.setMsg(baseResult.getMsg());
        return commonResponse;
    }

    public static CommonResponse fail(BusinessException e) {
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setCode(e.getCode());
        commonResponse.setMsg(e.getMessage());
        return commonResponse;
    }
}

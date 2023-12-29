package com.template.Controller;

import com.template.common.ResultEnum;
import com.template.common.exception.BusinessException;
import com.template.common.req.LongIdReq;
import com.template.common.req.StringIdReq;
import com.template.common.resp.CommonResponse;
import com.template.common.resp.DataResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
public class TestController {

    @RequestMapping(value = "/getTest1", method = RequestMethod.GET)
    public CommonResponse getTest1(@RequestParam(value = "nickname", required = false) String name) {
        log.info("name=nickname={}", name);
        return CommonResponse.success();
    }

    @RequestMapping(value = "/postTest1", method = RequestMethod.POST)
    public CommonResponse postTest1(String userId) {
        log.info("userId={}", userId);
        return CommonResponse.fail(ResultEnum.ERROR);
    }

    @RequestMapping(value = "/postTest2", method = RequestMethod.POST)
    public CommonResponse postTest2(LongIdReq req) {
        log.info("QueryUserReq={}", req.getId());
        return CommonResponse.fail(new BusinessException(ResultEnum.ERROR));
    }

    @RequestMapping(value = "/postTest3", method = RequestMethod.POST)
    public DataResponse<StringIdReq> postTest3(@RequestBody @Valid StringIdReq req) {
        log.info("QueryUserReq={}", req.getId());
        return DataResponse.success(req);
    }

}

package com.template.Controller;

import com.template.common.BusinessException;
import com.template.common.Response;
import com.template.common.ResultEnum;
import com.template.model.req.QueryUserReq;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
public class TestController {

    @RequestMapping(value = "/getTest1", method = RequestMethod.GET)
    public Response<?> getTest1(@RequestParam(value = "nickname", required = false) String name) {
        log.info("name=nickname={}", name);
        return new Response<>().success();
    }

    @RequestMapping(value = "/postTest1", method = RequestMethod.POST)
    public Response<?> postTest1(String userId) {
        log.info("userId={}", userId);
        return new Response<>().fail(ResultEnum.ERROR);
    }

    @RequestMapping(value = "/postTest2", method = RequestMethod.POST)
    public Response<?> postTest2(QueryUserReq req) {
        log.info("QueryUserReq={}", req.getUserId());
        return new Response<>().fail(new BusinessException(ResultEnum.ERROR));
    }

    @RequestMapping(value = "/postTest3", method = RequestMethod.POST)
    public Response<?> postTest3(@RequestBody @Valid QueryUserReq req) {
        log.info("QueryUserReq={}", req.getUserId());
        return new Response<>().success(req);
    }
}

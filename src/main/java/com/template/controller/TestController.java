package com.template.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.template.common.exception.BusinessException;
import com.template.common.resp.CommonResponse;
import com.template.common.resp.DataResponse;
import com.template.common.resp.ResultEnum;
import com.template.model.Student;
import com.template.model.req.LongIdReq;
import com.template.model.req.StringIdReq;
import com.template.service.RedisCache;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
public class TestController {

    @Resource
    private RedisCache redisCache;

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

    @RequestMapping(value = "/redisListPush", method = RequestMethod.GET)
    public DataResponse<?> redisListPush() {
        Student s1 = new Student("hhh", 10);
        Student s2 = new Student("rrr", 11);
        Student s3 = new Student("yyy", 12);
        List<Student> list = new ArrayList<>();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        long count = redisCache.setCacheList("list_key", list);
        return DataResponse.success(count);
    }

    @RequestMapping(value = "/redisListGet", method = RequestMethod.GET)
    public DataResponse<?> redisListGet() {
        List<JSONObject> list = redisCache.getCacheList("list_key");
        List<Student> result = list.stream()
                .map(o -> JSON.toJavaObject(o, Student.class))
                .collect(Collectors.toList());
        return DataResponse.success(result);
    }

}

package com.template.controller;


import com.template.common.resp.CommonResponse;
import com.template.common.resp.PageResponse;
import com.template.common.vo.PageVO;
import com.template.model.req.AddDeptReq;
import com.template.model.req.QueryDeptReq;
import com.template.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("dept")
public class DeptController {

    @Resource
    private DeptService deptService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public CommonResponse addDept(@RequestBody AddDeptReq req) {
        deptService.addDept(req);
        return CommonResponse.success();
    }

    @RequestMapping(value = "/query", method = RequestMethod.POST)
    public PageResponse<?> pageQuery(@RequestBody QueryDeptReq req) {
        PageVO<?> pageVO = deptService.pageQuery(req);
        return PageResponse.success(pageVO);
    }

}

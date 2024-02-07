package com.template.controller;


import com.template.common.resp.CommonResponse;
import com.template.model.req.AddEmployeeReq;
import com.template.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("employee")
public class EmployeeController {

    @Resource
    private EmployeeService employeeService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public CommonResponse addEmployee(@RequestBody AddEmployeeReq req) {
        employeeService.addEmployee(req);
        return CommonResponse.success();
    }

//    @RequestMapping(value = "/query", method = RequestMethod.POST)
//    public PageResponse<?> pageQuery(@RequestBody QueryDeptReq req) {
//        PageVO<?> pageVO = deptService.pageQuery(req);
//        return PageResponse.success(pageVO);
//    }

}

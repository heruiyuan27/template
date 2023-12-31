package com.template.Controller;


import com.template.common.resp.CommonResponse;
import com.template.model.req.AddDeptReq;
import com.template.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("dept")
public class DeptController {

    @Autowired
    private DeptService deptService;


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public CommonResponse addDept(@RequestBody AddDeptReq req) {
        deptService.addDept(req);
        return CommonResponse.success();
    }


}

package com.template.service.impl;

import com.template.dao.mapper.DeptMapper;
import com.template.model.entity.Dept;
import com.template.model.req.AddDeptReq;
import com.template.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Slf4j
@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;

    @Override
    public void addDept(@RequestBody AddDeptReq req) {
        Dept dept = new Dept();
        dept.setDeptId(req.getDeptId());
        dept.setDeptName(req.getDeptName());
        deptMapper.insert(dept);
    }
}

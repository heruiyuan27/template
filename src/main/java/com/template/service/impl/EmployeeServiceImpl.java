package com.template.service.impl;

import com.template.dao.mapper.EmployeeMapper;
import com.template.model.entity.EmployeeEntity;
import com.template.model.req.AddEmployeeReq;
import com.template.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.Resource;

@Slf4j
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Resource
    private EmployeeMapper employeeMapper;

    @Override
    public void addEmployee(AddEmployeeReq req) {
        Assert.notNull(req, "用户信息不能为空");
        EmployeeEntity emp = new EmployeeEntity();
        emp.setEmployeeId(req.getEmployeeId());
        emp.setEmployeeNickname(req.getEmployeeNickname());
        emp.setEmployeeHead(req.getEmployeeHead());
        emp.setEmployeePassword(req.getEmployeePassword());
        emp.setDeptId(req.getDeptId());
        emp.setLevel(req.getLevel().getLevel());
        emp.setTitle(req.getLevel().getTitle());
        employeeMapper.insertEmployee(emp);
    }
}

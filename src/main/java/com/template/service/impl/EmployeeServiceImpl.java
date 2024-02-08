package com.template.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.template.common.utils.PageUtil;
import com.template.common.vo.PageVO;
import com.template.dao.mapper.EmployeeMapper;
import com.template.model.entity.EmployeeEntity;
import com.template.model.req.AddEmployeeReq;
import com.template.model.req.QueryEmployeeReq;
import com.template.model.vo.EmployeeVO;
import com.template.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.List;

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

    @Override
    public PageVO<EmployeeVO> pageQueryEmployee(QueryEmployeeReq req) {
        Page<EmployeeVO> page = PageUtil.createPage(req);
        List<EmployeeVO> employeeVOList = employeeMapper.pageQueryEmployee(page,req);
        PageVO<EmployeeVO> pageVO = PageUtil.createPageVO(page);
        pageVO.setData(employeeVOList);
        return pageVO;
    }
}

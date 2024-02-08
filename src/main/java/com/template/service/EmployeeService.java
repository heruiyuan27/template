package com.template.service;


import com.template.common.vo.PageVO;
import com.template.model.req.AddEmployeeReq;
import com.template.model.req.QueryEmployeeReq;
import com.template.model.vo.EmployeeVO;

public interface EmployeeService {

    void addEmployee(AddEmployeeReq req);

    PageVO<EmployeeVO> pageQueryEmployee(QueryEmployeeReq req);
}

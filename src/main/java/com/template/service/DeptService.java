package com.template.service;


import com.template.common.vo.PageVO;
import com.template.model.req.AddDeptReq;
import com.template.model.req.QueryDeptReq;

public interface DeptService {

    void addDept(AddDeptReq req);

    PageVO<?> pageQuery(QueryDeptReq req);
}

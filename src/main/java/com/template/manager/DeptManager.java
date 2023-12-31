package com.template.manager;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.template.model.entity.DeptEntity;
import com.template.model.req.QueryDeptReq;

public interface DeptManager {
    Page<DeptEntity> page(QueryDeptReq req);
}

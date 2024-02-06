package com.template.manager.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.template.common.annotation.Manager;
import com.template.common.utils.PageUtil;
import com.template.dao.mapper.DeptMapper;
import com.template.manager.DeptManager;
import com.template.model.entity.DeptEntity;
import com.template.model.req.QueryDeptReq;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;
import java.util.Objects;

@Manager
@Slf4j
public class DeptManagerImpl implements DeptManager {

    public static final Integer NOT_DELETED = 0;

    @Resource
    private DeptMapper deptMapper;

    @Override
    public Page<DeptEntity> page(QueryDeptReq req) {
        Page<DeptEntity> page = PageUtil.createPage(req);
        LambdaQueryWrapper<DeptEntity> qw = new LambdaQueryWrapper<>();
        qw.le(Objects.nonNull(req.getEndTime()), DeptEntity::getCreateTime, req.getEndTime())
                .ge(Objects.nonNull(req.getStartTime()), DeptEntity::getCreateTime, req.getStartTime())
                .eq(DeptEntity::getDeleted, NOT_DELETED)
                .orderByDesc(DeptEntity::getCreateTime)
                .orderByDesc(DeptEntity::getId);
        deptMapper.selectPage(page, qw);
        return page;
    }
}

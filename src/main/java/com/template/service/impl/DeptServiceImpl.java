package com.template.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.template.common.utils.PageUtil;
import com.template.common.vo.PageVO;
import com.template.dao.mapper.DeptMapper;
import com.template.manager.DeptManager;
import com.template.model.entity.DeptEntity;
import com.template.model.req.AddDeptReq;
import com.template.model.req.QueryDeptReq;
import com.template.model.vo.DeptVO;
import com.template.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class DeptServiceImpl implements DeptService {
    @Resource
    private DeptMapper deptMapper;

    @Resource
    private DeptManager deptManager;

    @Override
    public void addDept(AddDeptReq req) {
        DeptEntity deptEntity = new DeptEntity();
        deptEntity.setDeptId(req.getDeptId());
        deptEntity.setDeptName(req.getDeptName());
        deptMapper.insert(deptEntity);
    }

    @Override
    public PageVO<DeptVO> pageQuery(QueryDeptReq req) {
        Page<DeptEntity> pageEntity = deptManager.page(req);
        List<DeptVO> DeptVOList = pageEntity.getRecords().stream().map(deptEntity -> {
            DeptVO deptVO = new DeptVO();
            deptVO.setDeptId(deptEntity.getDeptId());
            deptVO.setDeptName(deptEntity.getDeptName());
            deptVO.setCreateTime(deptEntity.getCreateTime());
            deptVO.setUpdateTime(deptEntity.getUpdateTime());
            return deptVO;
        }).collect(Collectors.toList());

        PageVO<DeptVO> pageVO = PageUtil.createPageVO(pageEntity);
        pageVO.setData(DeptVOList);
        return pageVO;
    }

}

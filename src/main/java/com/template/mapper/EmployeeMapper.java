package com.template.dao.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.template.model.entity.EmployeeEntity;
import com.template.model.req.QueryEmployeeReq;
import com.template.model.vo.EmployeeVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author hry
 * @since 2023-12-31 10:57:07
 */
@Mapper
public interface EmployeeMapper {

    void insertEmployee(EmployeeEntity entity);

    List<EmployeeVO> pageQueryEmployee(Page<EmployeeVO> page, @Param("req") QueryEmployeeReq req);
}

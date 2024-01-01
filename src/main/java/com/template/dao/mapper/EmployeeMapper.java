package com.template.dao.mapper;

import com.template.model.entity.EmployeeEntity;
import com.template.model.vo.EmployeeVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

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

    List<EmployeeVO> pageQueryEmployee(Map<String, Integer> map);

}

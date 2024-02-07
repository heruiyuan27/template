package com.template;

import com.template.dao.mapper.EmployeeMapper;
import com.template.model.entity.EmployeeEntity;
import com.template.model.vo.EmployeeVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Slf4j
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ApplicationTest {

    @Resource
    private EmployeeMapper employeeMapper;

    @Test
    public void insert() {
        employeeMapper.insertEmployee(
                EmployeeEntity.builder()
                        .employeeId("123456789")
                        .employeeNickname("test")
                        .employeePassword("000000").build()
        );
    }

    @Test
    public void query() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("startIndex", 0);
        map.put("pageSize", 3);
        List<EmployeeVO> list = employeeMapper.pageQueryEmployee(map);
        for (EmployeeVO e : list) {
            System.out.println(e);
        }
    }
}

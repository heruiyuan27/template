package com.template;

import com.template.dao.mapper.EmployeeMapper;
import com.template.model.entity.EmployeeEntity;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;

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
}

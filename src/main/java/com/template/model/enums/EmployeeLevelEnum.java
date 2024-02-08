package com.template.model.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 * 雇员职位
 */
@Getter
public enum EmployeeLevelEnum {

    T1("T-1", "初级工程师"),
    T2("T-2", "初级工程师"),
    T3("T-3", "中级工程师"),
    T4("T-4", "中级工程师"),
    T5("T-5", "高级工程师"),
    T6("T-6", "高级工程师"),
    T7("T-7", "架构师"),
    T8("T-8", "架构师");

    @EnumValue
    private final String level;

    private final String title;

    EmployeeLevelEnum(String level, String title) {
        this.level = level;
        this.title = title;
    }

}

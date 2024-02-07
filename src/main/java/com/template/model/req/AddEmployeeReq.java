package com.template.model.req;


import com.baomidou.mybatisplus.annotation.TableField;
import com.template.model.enums.EmployeeLevelEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddEmployeeReq {
    @Schema(description = "用户ID")
    @TableField("employee_id")
    private String employeeId;

    @Schema(description = "用户昵称")
    @TableField("employee_nickname")
    private String employeeNickname;

    @Schema(description = "用户头像")
    @TableField("employee_head")
    private String employeeHead;

    @Schema(description = "用户密码")
    @TableField("employee_password")
    private String employeePassword;

    @Schema(description = "部门ID")
    @TableField("dept_id")
    private String deptId;

    @Schema(description = "职级")
    @TableField("level")
    private EmployeeLevelEnum level;
}

package com.template.model.req;


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
    private String employeeId;

    @Schema(description = "用户昵称")
    private String employeeNickname;

    @Schema(description = "用户头像")
    private String employeeHead;

    @Schema(description = "用户密码")
    private String employeePassword;

    @Schema(description = "部门ID")
    private String deptId;

    @Schema(description = "职级")
    private EmployeeLevelEnum level;
}

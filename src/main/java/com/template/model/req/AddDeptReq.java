package com.template.model.req;


import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddDeptReq {
    @Schema(description = "部门ID")
    @TableField("dept_id")
    private String deptId;

    @Schema(description = "部门名称")
    @TableField("dept_name")
    private String deptName;
}

package com.template.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author hry
 * @since 2023-12-31 10:57:07
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("employee")
@Schema(name = "EmployeeEntity", description = "职员表")
public class EmployeeEntity {

    @Schema(description = "自增ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

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

    @Schema(description = "创建时间")
    @TableField("create_time")
    private Date createTime;

    @Schema(description = "更新时间")
    @TableField("update_time")
    private Date updateTime;

    @Schema(description = "部门ID")
    @TableField("dept_id")
    private String deptId;

    @Schema(description = "职级")
    @TableField("level")
    private String level;

    @Schema(description = "头衔")
    @TableField("title")
    private String title;
}

package com.template.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author hry
 * @since 2023-12-30 11:29:22
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@TableName("dept")
@Schema(name = "Dept", description = "部门表")
public class DeptEntity {

    @Schema(description = "自增ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @Schema(description = "部门ID")
    @TableField("dept_id")
    private String deptId;

    @Schema(description = "部门名称")
    @TableField("dept_name")
    private String deptName;

    @Schema(description = "创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    @Schema(description = "更新时间")
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @Schema(description = "是否逻辑删除")
    @TableField(value = "deleted", fill = FieldFill.INSERT)
    private Integer deleted;
}

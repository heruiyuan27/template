package com.template.model.vo;

import com.baomidou.mybatisplus.annotation.TableField;
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
public class EmployeeVO {
    @Schema(description = "用户ID")
    private String employeeId;

    @Schema(description = "用户昵称")
    private String employeeNickname;

    @Schema(description = "用户头像")
    private String employeeHead;

    @Schema(description = "创建时间")
    @TableField("create_time")
    private Date createTime;

    @Schema(description = "部门")
    private String deptName;

    @Schema(description = "头衔")
    private String title;

    @Override
    public String toString() {
        return "EmployeeVO{" +
                "employeeId='" + employeeId + '\'' +
                ", employeeNickname='" + employeeNickname + '\'' +
                ", employeeHead='" + employeeHead + '\'' +
                ", createTime=" + createTime +
                ", deptName='" + deptName + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}

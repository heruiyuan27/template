package com.template.model.req;

import com.template.common.req.PageReq;
import com.template.model.enums.EmployeeLevelEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QueryEmployeeReq extends PageReq {
    @Schema(description = "创建时间起始")
    private Date startTime;
    @Schema(description = "创建时间中止")
    private Date endTime;
    @Schema(description = "部门ID")
    private String deptId;
    @Schema(description = "职级")
    private List<EmployeeLevelEnum> levelEnumList;
}

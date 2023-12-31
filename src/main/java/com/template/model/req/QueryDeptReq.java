package com.template.model.req;

import com.template.common.req.PageReq;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QueryDeptReq extends PageReq {
    @Schema(description = "创建时间起始")
    private Date startTime;
    @Schema(description = "创建时间中止")
    private Date endTime;
}

package com.template.common.req;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PageReq {
    @Schema(description = "当前页数")
    protected long currentPage;
    @Schema(description = "每页数量")
    protected long pageSize;
    @Schema(description = "排序字段")
    protected String orderBy;
    @Schema(description = "排序顺序，true为升序，false为降序")
    protected Boolean asc;
}

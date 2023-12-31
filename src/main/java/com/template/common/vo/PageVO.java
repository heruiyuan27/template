package com.template.common.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PageVO<T> {
    @Schema(description = "当前页数")
    private long currentPage;
    @Schema(description = "每页数量")
    private long pageSize;
    @Schema(description = "数据总量")
    private long total;
    @Schema(description = "总页数")
    private long totalPage;

    private List<T> data;
}

package com.template.common.resp;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.template.common.ResultEnum;
import com.template.common.vo.PageVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PageResponse<T> extends BaseResponse {
    @Schema(description = "数据总量")
    private long total;
    @Schema(description = "总页数")
    private long totalPage;
    @Schema(description = "当前页数")
    private long currentPage;
    @Schema(description = "每页数量")
    private long pageSize;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<T> data;

    public static <T> PageResponse<T> success(PageVO<T> pageVO) {
        PageResponse<T> pageResponse = new PageResponse<>();
        pageResponse.setCode(ResultEnum.SUCCESS.getCode());
        pageResponse.setMsg(ResultEnum.SUCCESS.getMsg());
        pageResponse.setTotal(pageVO.getTotal());
        pageResponse.setTotalPage(pageVO.getTotalPage());
        pageResponse.setCurrentPage(pageVO.getCurrentPage());
        pageResponse.setPageSize(pageVO.getPageSize());
        pageResponse.setData(pageVO.getData());
        return pageResponse;
    }
}

package com.template.model.req;

import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StringIdListReq {
    @NotNull
    private List<String> idList;
}

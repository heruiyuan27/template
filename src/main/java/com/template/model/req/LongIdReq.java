package com.template.model.req;

import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LongIdReq {
    @NotNull
    private Long id;
}

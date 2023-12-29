package com.template.common.req;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StringIdReq {
    @NotBlank
    private String id;
}

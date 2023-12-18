package com.template.model.req;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QueryUserReq {
    @NotBlank
    private String userId;
}

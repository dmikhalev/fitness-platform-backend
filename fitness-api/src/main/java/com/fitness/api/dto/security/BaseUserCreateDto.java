package com.fitness.api.dto.security;

import lombok.Data;

import javax.validation.constraints.NotBlank;


@Data
public class BaseUserCreateDto {
    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @NotBlank
    private Role role;
}

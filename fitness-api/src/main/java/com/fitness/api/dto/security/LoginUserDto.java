
package com.fitness.api.dto.security;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class LoginUserDto {
    @NotBlank
    private String username;

    @NotBlank
    private String password;
}

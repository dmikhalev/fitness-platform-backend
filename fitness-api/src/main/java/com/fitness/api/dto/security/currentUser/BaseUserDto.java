package com.fitness.api.dto.security.currentUser;

import com.fitness.api.dto.security.Role;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
public class BaseUserDto {
    @NotBlank
    private String username;

    @NotBlank
    private Role role;
}

package com.fitness.api.dto.security.currentUser;

import com.fitness.api.dto.security.Role;
import lombok.Data;

import javax.validation.constraints.NotBlank;

import java.time.LocalDate;


public class ClientInfoDto extends BaseUserDto {
    private final LocalDate birthday;

    private final String name;

    @NotBlank
    private final String email;

    private final String phone;

    public ClientInfoDto(@NotBlank String username, @NotBlank Role role, LocalDate birthday, String name, String email, String phone) {
        super(username, role);
        this.birthday = birthday;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }
}

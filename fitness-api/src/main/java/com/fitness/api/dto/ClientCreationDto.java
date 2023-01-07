package com.fitness.api.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Calendar;

@Data
public class ClientCreationDto {
    @NotBlank
    @Size(min = 2, max = 50)
    private String username;

    @NotBlank
    private Calendar birthday;

    @NotBlank
    @Size(min = 2, max = 50)
    private String firstName;

    @NotBlank
    @Size(min = 2, max = 50)
    private String lastName;

    @NotBlank
    @Size(min = 8, max = 50)
    private String password;

    @NotBlank
    @Pattern(regexp = "^(.+)@(\\S+)$")
    private String email;

    @NotBlank
    private String phone;
}

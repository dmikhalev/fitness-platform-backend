package com.fitness.api.dto;

import lombok.Data;

import java.util.Calendar;

@Data
public class ClientCreationDto {
    private String username;

    private Calendar birthday;

    private String firstName;

    private String lastName;

    private String password;

    private String email;

    private String phone;

}

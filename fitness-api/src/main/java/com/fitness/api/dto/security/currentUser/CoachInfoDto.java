package com.fitness.api.dto.security.currentUser;

import com.fitness.api.dto.security.Role;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

public class CoachInfoDto extends BaseUserDto {


    private final LocalDate birthday;


    private final String firstName;


    private final String middleName;


    private final String lastName;


    private final String phone;


    private final String email;


    private final String profileDescription;


    private final int workExperience;

    public CoachInfoDto(@NotBlank String username, @NotBlank Role role, LocalDate birthday, String firstName, String middleName, String lastName, String phone, String email, String profileDescription, int workExperience) {
        super(username, role);
        this.birthday = birthday;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.profileDescription = profileDescription;
        this.workExperience = workExperience;
    }
}

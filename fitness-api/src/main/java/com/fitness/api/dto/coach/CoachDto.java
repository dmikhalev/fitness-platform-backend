package com.fitness.api.dto.coach;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class CoachDto {

    @Size(min = 2, max = 50)
    private String firstName;

    @Size(min = 2, max = 50)
    private String middleName;

    @Size(min = 2, max = 50)
    private String lastName;

    @NotBlank
    private String profileDescription;

    @NotBlank
    private int workExperience;
}

package com.fitness.api.dto.coach;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
public class CoachCreateDto {
    @NotBlank
    @Size(min = 2, max = 50)
    private String username;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;

    @Size(min = 2, max = 50)
    private String firstName;

    @Size(min = 2, max = 50)
    private String middleName;

    @Size(min = 2, max = 50)
    private String lastName;

    @NotBlank
    @Pattern(regexp = "^(.+)@(\\S+)$")
    private String email;

    @NotBlank
    private String phone;

    @NotBlank
    private String profileDescription;

    @NotBlank
    private int workExperience;
}

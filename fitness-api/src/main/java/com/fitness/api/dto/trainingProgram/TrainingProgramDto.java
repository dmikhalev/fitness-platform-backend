package com.fitness.api.dto.trainingProgram;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class TrainingProgramDto {

    @NotBlank
    private Long id;

    @NotBlank
    @Size(min = 2, max = 100)
    private String title;

    @NotBlank
    private String description;

    @NotBlank
    private String type;

    @NotBlank
    private LocalDate creationDate;
}

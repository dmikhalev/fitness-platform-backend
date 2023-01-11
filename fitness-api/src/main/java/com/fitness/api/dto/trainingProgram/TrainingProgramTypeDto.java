package com.fitness.api.dto.trainingProgram;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class TrainingProgramTypeDto {

    @NotBlank
    private String type;
}

package com.fitness.api.dto.trainingProgram;

import lombok.Data;

@Data
public class TrainingProgramReleaseDto {
    private long trainingProgramId;
    private boolean isReleased;
}

package com.fitness.api.dto.video;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class VideoCreateDto {
    @NotBlank
    private String link;

    @Size(min = 2, max = 50)
    private String title;

    @NotBlank
    private String description;

    @NotBlank
    private Long trainingProgramId;
}

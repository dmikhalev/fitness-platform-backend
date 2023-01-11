package com.fitness.api.dto.trainingProgram;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fitness.api.dto.coach.CoachDto;
import com.fitness.api.dto.video.VideoDto;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Data
public class TrainingProgramCreateDto {

    @NotBlank
    @Size(min = 2, max = 100)
    private String title;

    @NotBlank
    private String description;

    @NotBlank
    private String type;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate creationDate;

    @NotBlank
    private CoachDto coach;

    @NotBlank
    private List<VideoDto> videos;
}

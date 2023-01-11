package com.fitness.api.dto.trainingProgram;

import com.fitness.api.dto.video.VideoDto;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Data
public class FullTrainingProgramDto {

    @NotBlank
    @Size(min = 2, max = 100)
    private String title;

    @NotBlank
    private String description;

    @NotBlank
    private String type;

    @NotBlank
    private LocalDate creationDate;

    @NotBlank
    private String coachName;

    @NotBlank
    private List<VideoDto> videos;

    public FullTrainingProgramDto(String title, String description, String type, LocalDate creationDate, String coachName, List<VideoDto> videos) {
        this.title = title;
        this.description = description;
        this.type = type;
        this.creationDate = creationDate;
        this.coachName = coachName;
        this.videos = videos;
    }
}

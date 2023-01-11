package com.fitness.api.dto.video;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class VideoDto {

    @NotBlank
    private String link;

    @Size(min = 2, max = 50)
    private String title;

    @NotBlank
    private String description;

    public VideoDto(String link, String title, String description) {
        this.link = link;
        this.title = title;
        this.description = description;
    }
}

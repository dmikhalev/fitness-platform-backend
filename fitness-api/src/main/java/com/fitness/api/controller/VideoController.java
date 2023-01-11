package com.fitness.api.controller;

import com.fitness.api.dto.video.VideoCreateDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/api/video")
public interface VideoController {

    @PostMapping("/save")
    ResponseEntity<Object> createVideos(@Valid @RequestBody List<VideoCreateDto> videoCreateDtos);


}


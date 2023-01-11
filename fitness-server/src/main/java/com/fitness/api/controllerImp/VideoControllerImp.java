package com.fitness.api.controllerImp;

import com.fitness.api.controller.VideoController;
import com.fitness.api.dto.video.VideoCreateDto;
import com.fitness.api.exception.VideoException;
import com.fitness.api.service.VideoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class VideoControllerImp implements VideoController {
    private final VideoService videoService;

    @Override
    public ResponseEntity<Object> createVideos(List<VideoCreateDto> videoCreateDtos) {
        try {
            videoService.createVideos(videoCreateDtos);
        } catch (VideoException e) {
            return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED); // NOT_IMPLEMENTED ?
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}

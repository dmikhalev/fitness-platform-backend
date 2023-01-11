package com.fitness.api.service;

import com.fitness.api.data.entity.TrainingProgramEntity;
import com.fitness.api.data.entity.VideoEntity;
import com.fitness.api.data.repository.VideoRepository;
import com.fitness.api.dto.video.VideoCreateDto;
import com.fitness.api.exception.VideoException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class VideoService {

    private final VideoRepository videoRepository;
    private final TrainingProgramService trainingProgramService;

    public void createVideo(VideoCreateDto videoCreateDto) throws VideoException {
        TrainingProgramEntity trainingProgram = trainingProgramService.findById(videoCreateDto.getTrainingProgramId());
        if (trainingProgram == null) {
            throw new VideoException("Failed to create video");
        }
        VideoEntity video = new VideoEntity(
                videoCreateDto.getLink(),
                videoCreateDto.getTitle(),
                videoCreateDto.getDescription(),
                trainingProgram
        );
        videoRepository.save(video);
    }

    public void createVideos(List<VideoCreateDto> videoCreateDtos) throws VideoException {
        if (videoCreateDtos == null || videoCreateDtos.isEmpty()) {
            return;
        }
        long trainingProgramId = videoCreateDtos.get(0).getTrainingProgramId();
        TrainingProgramEntity trainingProgram = trainingProgramService.findById(trainingProgramId);
        if (trainingProgram == null) {
            throw new VideoException("Failed to create video");
        }
        List<VideoEntity> videoEntities = videoCreateDtos.stream()
                .map(dto ->
                        new VideoEntity(
                                dto.getLink(),
                                dto.getTitle(),
                                dto.getDescription(),
                                trainingProgram))
                .toList();
        videoRepository.saveAll(videoEntities);
    }
}

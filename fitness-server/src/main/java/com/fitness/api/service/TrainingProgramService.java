package com.fitness.api.service;

import com.fitness.api.data.entity.CoachEntity;
import com.fitness.api.data.entity.TrainingProgramEntity;
import com.fitness.api.data.mapper.TrainingProgramMapper;
import com.fitness.api.data.repository.TrainingProgramRepository;
import com.fitness.api.dto.trainingProgram.FullTrainingProgramDto;
import com.fitness.api.dto.trainingProgram.TrainingProgramCreateDto;
import com.fitness.api.dto.trainingProgram.TrainingProgramDto;
import com.fitness.api.dto.trainingProgram.TrainingProgramReleaseDto;
import com.fitness.api.dto.video.VideoDto;
import com.fitness.api.exception.TrainingProgramException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
public class TrainingProgramService {

    private final TrainingProgramRepository trainingProgramRepository;
    private final SecurityService securityService;

    public void createTrainingProgram(TrainingProgramCreateDto trainingProgramCreateDto) throws TrainingProgramException {
        CoachEntity coach = securityService.getCurrentCoach();
        if (coach == null) {
            throw new TrainingProgramException("Failed to create training program. Coach not found.");
        }
        var trainingProgram = TrainingProgramMapper.INSTANCE.trainingProgramCreateDtoToTrainingProgram(trainingProgramCreateDto);
        trainingProgram.setIsReleased(false);
        trainingProgram.setCreationDate(LocalDate.now());
        trainingProgram.setCoach(coach);
        trainingProgramRepository.save(trainingProgram);
    }

    public TrainingProgramEntity findByCoach(CoachEntity coach) {
        return trainingProgramRepository.findByCoach(coach)
                .orElseThrow(EntityNotFoundException::new);
    }

    public TrainingProgramEntity findById(long id) {
        return trainingProgramRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    public List<TrainingProgramEntity> findByTypeAndCoach(String type, CoachEntity coach) {
        return new ArrayList<>(trainingProgramRepository.findByTypeAndCoach(type, coach));
    }

    public void releaseTrainingProgram(TrainingProgramReleaseDto trainingProgramReleaseDto) {
        long trainingProgramId = trainingProgramReleaseDto.getTrainingProgramId();
        TrainingProgramEntity trainingProgram = trainingProgramRepository
                .findById(trainingProgramId)
                .orElseThrow(EntityNotFoundException::new);
        boolean isReleased = trainingProgramReleaseDto.isReleased();
        if (trainingProgram.getIsReleased() != isReleased) {
            trainingProgram.setIsReleased(isReleased);
            trainingProgramRepository.save(trainingProgram);
        }
    }

    public List<TrainingProgramDto> getTrainingProgramsByType(String type) {
        List<TrainingProgramEntity> trainingPrograms = trainingProgramRepository.findByTypeAndIsReleasedTrue(type);
        if (trainingPrograms == null) {
            return Collections.emptyList();
        }
        return toDtos(trainingPrograms);
    }

    public List<TrainingProgramDto> getNotReleasedTrainingPrograms() {
        List<TrainingProgramEntity> trainingPrograms = trainingProgramRepository.findAllByIsReleasedIsFalse();
        if (trainingPrograms == null) {
            return Collections.emptyList();
        }
        return toDtos(trainingPrograms);
    }

    private List<TrainingProgramDto> toDtos(List<TrainingProgramEntity> trainingPrograms) {
        return trainingPrograms.stream()
                .map(prog -> new TrainingProgramDto(
                        prog.getId(),
                        prog.getTitle(),
                        prog.getDescription(),
                        prog.getType(),
                        prog.getCreationDate(),
                        prog.getIsReleased()
                )).toList();
    }

    public FullTrainingProgramDto getFullTrainingProgramById(Long id) {
        TrainingProgramEntity trainingProgram = findById(id);
        List<VideoDto> videoDtos = trainingProgram.getVideos().stream()
                .map(v -> new VideoDto(
                        v.getLink(),
                        v.getTitle(),
                        v.getDescription()
                )).toList();
        return new FullTrainingProgramDto(
                trainingProgram.getTitle(),
                trainingProgram.getDescription(),
                trainingProgram.getType(),
                trainingProgram.getCreationDate(),
                trainingProgram.getCoach().getFullName(),
                videoDtos
        );
    }
}

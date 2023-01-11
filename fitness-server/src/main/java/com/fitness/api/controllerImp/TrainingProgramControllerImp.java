package com.fitness.api.controllerImp;

import com.fitness.api.controller.TrainingProgramController;
import com.fitness.api.dto.trainingProgram.FullTrainingProgramDto;
import com.fitness.api.dto.trainingProgram.TrainingProgramCreateDto;
import com.fitness.api.dto.trainingProgram.TrainingProgramDto;
import com.fitness.api.dto.trainingProgram.TrainingProgramReleaseDto;
import com.fitness.api.exception.TrainingProgramException;
import com.fitness.api.service.TrainingProgramService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class TrainingProgramControllerImp implements TrainingProgramController {

    private final TrainingProgramService trainingProgramService;


    @Override
    public ResponseEntity<Object> createTrainingProgram(TrainingProgramCreateDto trainingProgramCreateDto) {
        try {
            trainingProgramService.createTrainingProgram(trainingProgramCreateDto);
        } catch (TrainingProgramException e) {
            return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED); // NOT_IMPLEMENTED ?
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Object> releaseTrainingProgram(TrainingProgramReleaseDto trainingProgramReleaseDto) {
        trainingProgramService.releaseTrainingProgram(trainingProgramReleaseDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<TrainingProgramDto>> getRelevantTrainingPrograms(String type) {
        List<TrainingProgramDto> trainingProgramDtos = trainingProgramService.getTrainingProgramsByType(type);
        return ResponseEntity.ok(trainingProgramDtos);
    }

    @Override
    public ResponseEntity<FullTrainingProgramDto> getFullTrainingProgramById(Long id) {
        FullTrainingProgramDto trainingProgram = trainingProgramService.getFullTrainingProgramById(id);
        return ResponseEntity.ok(trainingProgram);
    }
}

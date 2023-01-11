package com.fitness.api.controller;

import com.fitness.api.dto.trainingProgram.FullTrainingProgramDto;
import com.fitness.api.dto.trainingProgram.TrainingProgramCreateDto;
import com.fitness.api.dto.trainingProgram.TrainingProgramDto;
import com.fitness.api.dto.trainingProgram.TrainingProgramReleaseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/api/training-program")
public interface TrainingProgramController {

    @PostMapping("/save")
    ResponseEntity<Object> createTrainingProgram(@Valid @RequestBody TrainingProgramCreateDto trainingProgramCreateDto);

    @PutMapping("/release")
    ResponseEntity<Object> releaseTrainingProgram(@Valid @RequestBody TrainingProgramReleaseDto trainingProgramReleaseDto);

    @GetMapping("/get-relevant/{type}")
    ResponseEntity<List<TrainingProgramDto>> getRelevantTrainingPrograms(@PathVariable String type);

    @GetMapping("/get/{id}")
    ResponseEntity<FullTrainingProgramDto> getFullTrainingProgramById(@PathVariable Long id);
}


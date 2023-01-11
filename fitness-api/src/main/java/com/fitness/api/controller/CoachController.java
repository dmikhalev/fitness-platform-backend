package com.fitness.api.controller;

import com.fitness.api.dto.coach.CoachCreateDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@RequestMapping("/api/coach")
public interface CoachController {

    @PostMapping("/save")
    ResponseEntity<Object> createCoach(@Valid @RequestBody CoachCreateDto coachCreateDto);


}


package com.fitness.api.controllerImp;

import com.fitness.api.controller.CoachController;
import com.fitness.api.dto.coach.CoachCreateDto;
import com.fitness.api.service.CoachService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class CoachControllerImp implements CoachController {
    private final CoachService coachService;

    @Override
    public ResponseEntity<Object> createCoach(CoachCreateDto coachCreateDto) {
        coachService.createCoach(coachCreateDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}

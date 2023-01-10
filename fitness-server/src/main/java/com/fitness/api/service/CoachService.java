package com.fitness.api.service;

import com.fitness.api.data.entity.BaseUserEntity;
import com.fitness.api.data.entity.CoachEntity;
import com.fitness.api.data.repository.CoachRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@AllArgsConstructor
public class CoachService {
    private final CoachRepository coachRepository;

    public CoachEntity getCoachEntityByBaseUser(BaseUserEntity baseUserEntity){
        var coach =  coachRepository.findByBaseUserEntity(baseUserEntity);
        if (coach == null){
            throw new EntityNotFoundException();
        }
        return coach;
    }

}

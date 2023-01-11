package com.fitness.api.data.repository;

import com.fitness.api.data.entity.CoachEntity;
import com.fitness.api.data.entity.TrainingProgramEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TrainingProgramRepository extends JpaRepository<TrainingProgramEntity, Long> {
    Optional<TrainingProgramEntity> findByCoach(CoachEntity coach);

    List<TrainingProgramEntity> findByTypeAndCoach(String type, CoachEntity coach);

    List<TrainingProgramEntity> findByType(String type);
}

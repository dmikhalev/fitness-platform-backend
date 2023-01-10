package com.fitness.api.data.repository;

import com.fitness.api.data.entity.BaseUserEntity;
import com.fitness.api.data.entity.CoachEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoachRepository extends JpaRepository<CoachEntity, Long> {
    CoachEntity findByBaseUserEntity(BaseUserEntity baseUserEntity);
}

package com.fitness.api.data.repository;

import com.fitness.api.data.entity.CharacteristicEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacteristicRepository extends JpaRepository<CharacteristicEntity, Long> {

}

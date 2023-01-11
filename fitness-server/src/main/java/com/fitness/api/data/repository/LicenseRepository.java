package com.fitness.api.data.repository;

import com.fitness.api.data.entity.LicenseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LicenseRepository extends JpaRepository<LicenseEntity, Long> {
}

package com.fitness.api.data.repository;

import com.fitness.api.data.entity.SystemUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<SystemUserEntity, Long> {

}

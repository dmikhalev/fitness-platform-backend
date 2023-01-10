package com.fitness.api.data.repository;

import com.fitness.api.data.entity.BaseUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseUserRepository extends JpaRepository<BaseUserEntity, Long> {

    @Query("select p from BaseUserEntity p where p.username=:username")
    BaseUserEntity findByUsername(@Param("username") String username);
}

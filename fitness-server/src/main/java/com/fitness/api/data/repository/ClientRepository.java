package com.fitness.api.data.repository;

import com.fitness.api.data.entity.BaseUserEntity;
import com.fitness.api.data.entity.ClientEntity;
import com.fitness.api.service.ClientService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Long> {
    ClientEntity findByBaseUserEntity(BaseUserEntity baseUserEntity);
}

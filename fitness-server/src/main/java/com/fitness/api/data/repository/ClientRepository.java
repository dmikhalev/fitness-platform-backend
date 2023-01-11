package com.fitness.api.data.repository;

import com.fitness.api.data.entity.BaseUserEntity;
import com.fitness.api.data.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Long> {
    ClientEntity findByBaseUserEntity(BaseUserEntity baseUserEntity);

    @Query("select c from ClientEntity c join BaseUserEntity b on c.baseUserEntity = b where b.username=:username")
    ClientEntity findByUsername(@Param("username") String username);
}

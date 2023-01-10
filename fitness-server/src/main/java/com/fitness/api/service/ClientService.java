package com.fitness.api.service;


import com.fitness.api.data.entity.BaseUserEntity;
import com.fitness.api.data.entity.ClientEntity;
import com.fitness.api.data.mapper.ClientMapper;
import com.fitness.api.data.repository.BaseUserRepository;
import com.fitness.api.data.repository.ClientRepository;
import com.fitness.api.dto.client.ClientCreateDto;
import lombok.AllArgsConstructor;
import org.hibernate.action.internal.EntityActionVetoException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;


@Service
@AllArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;
    private final PasswordEncoder passwordEncoder;
    private final BaseUserRepository baseUserRepository;

    public void createClient(ClientCreateDto clientCreateDto) {
        var client = ClientMapper.INSTANCE.clientDtoToClient(clientCreateDto);
        clientRepository.save(client);
    }

    public ClientEntity getClientByBaseUser(BaseUserEntity baseUserEntity){
        var clientEntity = clientRepository.findByBaseUserEntity(baseUserEntity);
        if (clientEntity == null){
            throw new EntityNotFoundException();
        }
        return clientEntity;
    }
}

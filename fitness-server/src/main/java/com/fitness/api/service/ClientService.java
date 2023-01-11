package com.fitness.api.service;


import com.fitness.api.data.entity.BaseUserEntity;
import com.fitness.api.data.entity.ClientEntity;
import com.fitness.api.data.mapper.ClientMapper;
import com.fitness.api.data.repository.BaseUserRepository;
import com.fitness.api.data.repository.ClientRepository;
import com.fitness.api.dto.client.CharacteristicDto;
import com.fitness.api.dto.client.ClientCreateDto;
import com.fitness.api.dto.client.LicenseCreateDto;
import lombok.AllArgsConstructor;
import org.hibernate.action.internal.EntityActionVetoException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;


@Service
@AllArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;
    private final BaseUserRepository baseUserRepository;
    private final LicenseService licenseService;
    private final CharacteristicService characteristicService;

    public void createClient(ClientCreateDto clientCreateDto) {
        var baseUserEntity = baseUserRepository.findByUsername(clientCreateDto.getUsername());
        if (baseUserEntity == null) {
            throw new EntityNotFoundException();
        }
        var client = ClientMapper.INSTANCE.clientDtoToClient(clientCreateDto);
        client.setBaseUserEntity(baseUserEntity);
        clientRepository.save(client);
    }

    public ClientEntity getClientByBaseUser(BaseUserEntity baseUserEntity) {
        var clientEntity = clientRepository.findByBaseUserEntity(baseUserEntity);
        if (clientEntity == null) {
            throw new EntityNotFoundException();
        }
        return clientEntity;
    }

    public void addNewLicense(LicenseCreateDto licenseCreateDto, String usernameFromContext) {
        var client = clientRepository.findByUsername(usernameFromContext);
        if (client == null) {
            throw new EntityNotFoundException();
        }
        licenseService.addNewLicense(client, licenseCreateDto);
    }

    public void addNewCharacteristic(CharacteristicDto characteristicDto, String usernameFromContext) {
        var client = clientRepository.findByUsername(usernameFromContext);
        if (client == null) {
            throw new EntityNotFoundException();
        }
        characteristicService.addNewCharacteristic(client, characteristicDto);
    }
}

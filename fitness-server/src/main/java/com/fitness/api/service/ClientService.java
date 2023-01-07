package com.fitness.api.service;

import com.fitness.api.data.mapper.ClientMapper;
import com.fitness.api.data.repository.ClientRepository;
import com.fitness.api.dto.ClientCreationDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;

    public void createClient(ClientCreationDto clientCreationDto) {
        var client = ClientMapper.INSTANCE.clientDtoToClient(clientCreationDto);
        clientRepository.save(client);
    }
}

package com.fitness.api.service;

import com.fitness.api.data.entity.CharacteristicEntity;
import com.fitness.api.data.entity.ClientEntity;
import com.fitness.api.data.repository.CharacteristicRepository;
import com.fitness.api.dto.client.CharacteristicDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CharacteristicService {
    private final CharacteristicRepository characteristicRepository;

    public void addNewCharacteristic(ClientEntity clientEntity, CharacteristicDto characteristicDto) {
        var characteristic = new CharacteristicEntity();
        characteristic.setClient(clientEntity);
        characteristic.setName(characteristic.getName());
        characteristic.setValue(characteristic.getValue());
        characteristicRepository.save(characteristic);
    }
}

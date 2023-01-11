package com.fitness.api.service;

import com.fitness.api.data.entity.ClientEntity;
import com.fitness.api.data.entity.LicenseEntity;
import com.fitness.api.data.repository.LicenseRepository;
import com.fitness.api.dto.client.LicenseCreateDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LicenseService {
    private final LicenseRepository licenseRepository;

    public void addNewLicense(ClientEntity clientEntity, LicenseCreateDto licenseCreateDto) {
        var license = new LicenseEntity();
        license.setStartDate(licenseCreateDto.getStartDate());
        license.setFinishDate(licenseCreateDto.getStartDate().plusDays(licenseCreateDto.getDayOfLicense()));
        license.setClient(clientEntity);
        licenseRepository.save(license);
    }

}

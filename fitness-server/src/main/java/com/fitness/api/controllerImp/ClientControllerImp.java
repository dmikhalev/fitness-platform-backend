package com.fitness.api.controllerImp;

import com.fitness.api.controller.ClientController;
import com.fitness.api.dto.client.CharacteristicDto;
import com.fitness.api.dto.client.ClientCreateDto;
import com.fitness.api.dto.client.LicenseCreateDto;
import com.fitness.api.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class ClientControllerImp implements ClientController {
    private final ClientService clientService;

    @Override
    public ResponseEntity<Object> createClient(ClientCreateDto clientCreateDto) {
        clientService.createClient(clientCreateDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Object> addNewLicense(LicenseCreateDto licenseCreateDto) {
        clientService.addNewLicense(licenseCreateDto, getUsernameFromContext());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Object> addNewCharacteristic(CharacteristicDto characteristicDto) {
        clientService.addNewCharacteristic(characteristicDto, getUsernameFromContext());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    private String getUsernameFromContext() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!authentication.isAuthenticated()) {
            new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        return authentication.getName();
    }
}

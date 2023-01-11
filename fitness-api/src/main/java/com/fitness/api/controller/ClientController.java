package com.fitness.api.controller;

import com.fitness.api.dto.client.CharacteristicDto;
import com.fitness.api.dto.client.ClientCreateDto;
import com.fitness.api.dto.client.LicenseCreateDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@RequestMapping("/api/client")
public interface ClientController {

    @PostMapping("/save")
    ResponseEntity<Object> createClient(@Valid @RequestBody ClientCreateDto clientCreateDto);

    @PostMapping("/license")
    ResponseEntity<Object> addNewLicense(@Valid @RequestBody LicenseCreateDto licenseCreateDto);


    @PostMapping("/characteristic")
    ResponseEntity<Object> addNewCharacteristic(@Valid @RequestBody CharacteristicDto characteristicDto);
}


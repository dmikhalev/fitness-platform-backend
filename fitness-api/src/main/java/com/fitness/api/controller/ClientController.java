package com.fitness.api.controller;

import com.fitness.api.dto.client.ClientCreateDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@RequestMapping("/api/client")
public interface ClientController {

    @PostMapping("/save")
    ResponseEntity<Object> createClient(@Valid @RequestBody ClientCreateDto clientCreateDto);

}


package com.fitness.api.controller;

import com.fitness.api.dto.client.ClientCreateDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/api/client")
public interface ClientController {

    @PostMapping("/save")
    ResponseEntity<Object> createClient(@Valid @RequestBody ClientCreateDto clientCreateDto);


}


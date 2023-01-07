package com.fitness.api.controller;

import com.fitness.api.dto.ClientCreationDto;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/client")
public interface ClientController {

    @PostMapping("/save")
    void createClient(@Valid @RequestBody ClientCreationDto clientCreationDto);

}


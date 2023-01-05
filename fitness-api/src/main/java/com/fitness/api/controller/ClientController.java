package com.fitness.api.controller;

import com.fitness.api.dto.ClientCreationDto;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/client")
public interface ClientController {

    @PostMapping("/save")
    public void createClient(@RequestBody ClientCreationDto clientCreationDto);
}


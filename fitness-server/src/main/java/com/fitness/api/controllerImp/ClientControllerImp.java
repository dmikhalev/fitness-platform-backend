package com.fitness.api.controllerImp;

import com.fitness.api.controller.ClientController;
import com.fitness.api.dto.client.ClientCreateDto;
import com.fitness.api.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

}

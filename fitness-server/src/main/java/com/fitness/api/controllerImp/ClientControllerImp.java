package com.fitness.api.controllerImp;

import com.fitness.api.controller.ClientController;
import com.fitness.api.dto.ClientCreationDto;
import com.fitness.api.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class ClientControllerImp implements ClientController {
    private final ClientService clientService;

    @Override
    public void createClient(ClientCreationDto clientCreationDto) {

    }
}

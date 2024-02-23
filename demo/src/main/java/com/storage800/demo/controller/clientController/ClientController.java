package com.storage800.demo.controller.clientController;

import com.storage800.demo.entity.client.dto.ClientDto;
import com.storage800.demo.service.clientService.IClientService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api")
public class ClientController {

    @Autowired
    private IClientService clientService;

    @PostMapping(path = "/client/create")
    public ResponseEntity<?> create(@NonNull @RequestBody ClientDto clientDto)
    {
        var id = clientService.CreateNewClient(clientDto);
    }
}

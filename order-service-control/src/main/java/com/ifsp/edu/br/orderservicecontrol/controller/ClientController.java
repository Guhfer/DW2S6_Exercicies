package com.ifsp.edu.br.orderservicecontrol.controller;

import com.ifsp.edu.br.orderservicecontrol.controller.resources.response.ClientResponse;
import com.ifsp.edu.br.orderservicecontrol.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("clients")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public ResponseEntity<List<ClientResponse>> getAll() {
        return new ResponseEntity<>(clientService.getAllClients(), HttpStatus.OK);
    }
}

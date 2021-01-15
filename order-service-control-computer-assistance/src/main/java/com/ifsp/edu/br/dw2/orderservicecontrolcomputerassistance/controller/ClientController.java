package com.ifsp.edu.br.dw2.orderservicecontrolcomputerassistance.controller;

import com.ifsp.edu.br.dw2.orderservicecontrolcomputerassistance.controller.resource.request.AddressRequest;
import com.ifsp.edu.br.dw2.orderservicecontrolcomputerassistance.controller.resource.request.ClientRequest;
import com.ifsp.edu.br.dw2.orderservicecontrolcomputerassistance.controller.resource.response.ClientResponse;
import com.ifsp.edu.br.dw2.orderservicecontrolcomputerassistance.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import javax.validation.Valid;
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

    @GetMapping("/{id}")
    public ResponseEntity<ClientResponse> getClientById(@PathVariable Long id) {
        try{
            return new ResponseEntity<>(clientService.getClientById(id), HttpStatus.OK);
        } catch (HttpClientErrorException e) {
            return new ResponseEntity<>(e.getStatusCode());
        }
    }

    @PostMapping
    public ResponseEntity<ClientResponse> newClient(@RequestBody @Valid ClientRequest clientRequest) {
        return new ResponseEntity<>(clientService.saveClient(clientRequest), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ClientResponse> updateClient(@PathVariable Long id,
                                                       @RequestBody @Valid ClientRequest clientRequest) {
        return new ResponseEntity<>(clientService.updateClient(clientRequest, id), HttpStatus.OK);
    }

    @PutMapping("/address/update/{id}")
    public ResponseEntity<ClientResponse> updateAddress(@PathVariable Long id,
                                                         @RequestBody @Valid AddressRequest addressRequest) {
        return new ResponseEntity<>(clientService.updateAddress(addressRequest, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {

        clientService.deleteClient(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

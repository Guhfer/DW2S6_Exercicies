package com.ifsp.edu.br.orderservicecontrol.service;

import com.ifsp.edu.br.orderservicecontrol.controller.resources.response.ClientResponse;
import com.ifsp.edu.br.orderservicecontrol.entity.ClientEntity;
import com.ifsp.edu.br.orderservicecontrol.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<ClientResponse> getAllClients() {
        List<ClientEntity> clients = new ArrayList<ClientEntity>();
        clientRepository.findAll().forEach(clients::add);
        return clients.stream().map(this::buildClientResponse).collect(Collectors.toList());
    }

    private ClientResponse buildClientResponse(ClientEntity clientEntity) {
        return new ClientResponse(clientEntity);
    }
}

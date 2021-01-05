package com.ifsp.edu.br.dw2.orderservicecontrolcomputerassistance.service;

import com.ifsp.edu.br.dw2.orderservicecontrolcomputerassistance.controller.resource.request.AddressRequest;
import com.ifsp.edu.br.dw2.orderservicecontrolcomputerassistance.controller.resource.request.ClientRequest;
import com.ifsp.edu.br.dw2.orderservicecontrolcomputerassistance.controller.resource.response.AddressResponse;
import com.ifsp.edu.br.dw2.orderservicecontrolcomputerassistance.controller.resource.response.ClientResponse;
import com.ifsp.edu.br.dw2.orderservicecontrolcomputerassistance.entity.AddressEntity;
import com.ifsp.edu.br.dw2.orderservicecontrolcomputerassistance.entity.ClientEntity;
import com.ifsp.edu.br.dw2.orderservicecontrolcomputerassistance.repository.ClientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<ClientResponse> getAllClients() {
        List<ClientEntity> clients = new ArrayList<>();
        clientRepository.findAll().forEach(clients::add);
        return clients.stream().map(this::buildClientResponse).collect(Collectors.toList());
    }

    public ClientResponse getClientById(Long id) {
       return buildClientResponse(clientRepository.findById(id)
               .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND, "Client not found")));

    }

    public ClientResponse updateClient(ClientRequest clientRequest, Long id) {

        Optional<ClientEntity> entity = Optional.ofNullable(clientRepository.findById(id).
                orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND, "Client not found")));
        ClientEntity clientEntity = new ClientEntity(clientRequest);
        clientEntity.setId(entity.get().getId());

        return buildClientResponse(clientRepository.save(clientEntity));

    }

    public void deleteClient(Long id) {
        Optional<ClientEntity> clientEntity = Optional.ofNullable(clientRepository.findById(id).
                orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND, "Client not found")));

        clientRepository.deleteById(id);
    }


    public ClientResponse updateAddress(AddressRequest addressRequest, Long id) {
        Optional<ClientEntity> clientEntity = Optional.ofNullable(clientRepository.findById(id).
                orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND, "Client not found")));

        AddressEntity addressEntity = new AddressEntity(addressRequest);
        clientEntity.get().setAddress(addressEntity);

        return buildClientResponse(clientRepository.save(clientEntity.get()));
    }

    public ClientResponse saveClient(ClientRequest clientRequest) {
        return buildClientResponse(clientRepository.save(new ClientEntity(clientRequest)));
    }


    private ClientResponse buildClientResponse(ClientEntity clientEntity) {
        return new ClientResponse(clientEntity);
    }
}

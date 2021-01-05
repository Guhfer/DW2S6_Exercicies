package com.ifsp.edu.br.dw2.orderservicecontrolcomputerassistance.controller.resource.response;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ifsp.edu.br.dw2.orderservicecontrolcomputerassistance.entity.ClientEntity;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ClientResponse {

    private Long id;
    private String name;
    private String email;
    private String phone;
    private String cpf;
    @JsonProperty("address")
    private AddressResponse addressResponse;

    public ClientResponse(Long id, String name, String email, String phone, String cpf, AddressResponse addressResponse) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.cpf = cpf;
        this.addressResponse = addressResponse;
    }

    public ClientResponse(ClientEntity clientEntity) {
        this.id = clientEntity.getId();
        this.name = clientEntity.getName();
        this.email = clientEntity.getEmail();
        this.phone = clientEntity.getPhone();
        this.cpf = clientEntity.getCpf();
        this.addressResponse = new AddressResponse(clientEntity.getAddress());
    }
}

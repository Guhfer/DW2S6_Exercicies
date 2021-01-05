package com.ifsp.edu.br.orderservicecontrol.controller.resources.response;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.ifsp.edu.br.orderservicecontrol.entity.ClientEntity;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ClientResponse {

    private Long id;
    private String name;
    private String email;
    private String phone;

    public ClientResponse(Long id, String name, String email, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public ClientResponse(ClientEntity clientEntity) {
        this.id = clientEntity.getId();
        this.name = clientEntity.getName();
        this.email = clientEntity.getEmail();
        this.phone = clientEntity.getPhone();
    }
}

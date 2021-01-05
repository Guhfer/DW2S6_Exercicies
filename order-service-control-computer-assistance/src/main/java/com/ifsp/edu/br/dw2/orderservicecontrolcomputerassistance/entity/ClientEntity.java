package com.ifsp.edu.br.dw2.orderservicecontrolcomputerassistance.entity;

import com.ifsp.edu.br.dw2.orderservicecontrolcomputerassistance.controller.resource.request.ClientRequest;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;

@Entity(name = "client")
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max=50)
    private String name;

    private String email;

    private String phone;

    private String cpf;

    @OneToOne(cascade = CascadeType.ALL)
    private AddressEntity address;

    public ClientEntity(ClientRequest clientRequest) {
        this.name = clientRequest.getName();
        this.email = clientRequest.getEmail();
        this.phone = clientRequest.getPhone();
        this.cpf = clientRequest.getCpf();
        this.address = new AddressEntity(clientRequest.getAddressRequest());
    }

    public ClientEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public AddressEntity getAddress() {
        return address;
    }

    public void setAddress(AddressEntity address) {
        this.address = address;
    }

}

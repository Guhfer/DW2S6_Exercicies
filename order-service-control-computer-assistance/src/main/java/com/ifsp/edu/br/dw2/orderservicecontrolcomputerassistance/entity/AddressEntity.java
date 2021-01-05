package com.ifsp.edu.br.dw2.orderservicecontrolcomputerassistance.entity;

import com.ifsp.edu.br.dw2.orderservicecontrolcomputerassistance.controller.resource.request.AddressRequest;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity(name = "address")
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;

    private Integer number;

    @Size(max = 100)
    private String complement;

    private String district;

    private String city;

    private String state;

    private String cep;

    @OneToOne
    private ClientEntity clientEntity;

    public AddressEntity(AddressRequest addressRequest) {
        this.street = addressRequest.getStreet();
        this.number = addressRequest.getNumber();
        this.complement = addressRequest.getComplement();
        this.district = addressRequest.getDistrict();
        this.city = addressRequest.getCity();
        this.state = addressRequest.getState();
        this.cep = addressRequest.getCep();
    }

    public AddressEntity() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}

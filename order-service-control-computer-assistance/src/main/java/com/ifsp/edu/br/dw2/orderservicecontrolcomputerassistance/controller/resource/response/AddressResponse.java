package com.ifsp.edu.br.dw2.orderservicecontrolcomputerassistance.controller.resource.response;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import com.ifsp.edu.br.dw2.orderservicecontrolcomputerassistance.entity.AddressEntity;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class AddressResponse {

    private String street;
    private Integer number;
    private String complement;
    private String district;
    private String city;
    private String state;
    private String cep;

    public AddressResponse(String street, Integer number, String complement, String district, String city, String state, String cep) {
        this.street = street;
        this.number = number;
        this.complement = complement;
        this.district = district;
        this.city = city;
        this.state = state;
        this.cep = cep;
    }

    public AddressResponse(AddressEntity addressEntity) {
        this.street = addressEntity.getStreet();
        this.number = addressEntity.getNumber();
        this.complement = addressEntity.getComplement();
        this.district = addressEntity.getDistrict();
        this.city = addressEntity.getCity();
        this.state = addressEntity.getState();
        this.cep = addressEntity.getCep();
    }
}

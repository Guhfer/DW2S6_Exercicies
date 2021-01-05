package com.ifsp.edu.br.dw2.orderservicecontrolcomputerassistance.controller.resource.request;

import com.fasterxml.jackson.annotation.JsonRootName;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@JsonRootName("address")
public class AddressRequest {

    @NotEmpty
    private String street;

    @NotEmpty
    private Integer number;

    @Size(max = 100)
    private String complement;

    @NotEmpty
    private String district;

    @NotEmpty
    private String city;

    @NotEmpty
    private String state;

    @NotEmpty
    private String cep;

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

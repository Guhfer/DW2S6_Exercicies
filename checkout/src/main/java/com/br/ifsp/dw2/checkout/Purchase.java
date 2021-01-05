package com.br.ifsp.dw2.checkout;

public class Purchase {

    private Long code;
    private String clientName;
    private String product;
    private Double amount;

    public Purchase(Long code, String clientName, String product, Double amount) {
        this.code = code;
        this.clientName = clientName;
        this.product = product;
        this.amount = amount;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}

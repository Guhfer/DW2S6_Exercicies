package com.br.ifsp.dw2.checkout;

import java.time.YearMonth;

public class CreditCard {

    private String cardNumber;
    private String clientName;
    private YearMonth validity;

    public CreditCard(String cardNumber, String clientName, YearMonth validity) {
        this.cardNumber = cardNumber;
        this.clientName = clientName;
        this.validity = validity;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public YearMonth getValidity() {
        return validity;
    }

    public void setValidity(YearMonth validity) {
        this.validity = validity;
    }
}

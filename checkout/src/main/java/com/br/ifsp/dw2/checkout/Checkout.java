package com.br.ifsp.dw2.checkout;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Checkout {

    @Autowired
    @Qualifier("masterCard")
    Operator operator;

    public void makePurchase(CreditCard creditCard, Purchase purchase) {

        System.out.println("Compra foi realiza: " + operator.authorize(creditCard, purchase));
    }
}

package com.br.ifsp.dw2.checkout;

public interface Operator {

    boolean authorize(CreditCard creditCard, Purchase purchase);
}

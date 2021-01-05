package com.br.ifsp.dw2.checkout;

import org.springframework.stereotype.Component;

import java.time.YearMonth;

@Component
public class MasterCard implements Operator {

    @Override
    public boolean authorize(CreditCard creditCard, Purchase purchase) {

        return creditCard.getCardNumber().startsWith("5678") &&
                purchase.getAmount() < 1000 &&
                YearMonth.now().isBefore(creditCard.getValidity());
    }
}

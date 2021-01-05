package com.br.ifsp.dw2.checkout;

import com.br.ifsp.dw2.checkout.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.YearMonth;

public class CheckoutApplication {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        CreditCard creditCard = new CreditCard("1234233430109903", "Gustavo Fernandes", YearMonth.of(2028,5));
        Purchase purchase = new Purchase(1L, "Gustavo Fernandes", "Teclado", 229.48);

        Checkout checkout = context.getBean(Checkout.class);

        checkout.makePurchase(creditCard, purchase);

        ((ConfigurableApplicationContext)context).close();

    }
}

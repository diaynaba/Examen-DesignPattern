package com.badwallet.badwallet_api.strategy;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class WalletStrategy implements PaymentStrategy {

    @Override
    public void pay(BigDecimal amount) {

        System.out.println("Paiement Wallet : " + amount);

    }

}
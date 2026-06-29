package com.badwallet.badwallet_api.strategy;

import java.math.BigDecimal;

public interface PaymentStrategy {

    void pay(BigDecimal amount);

}
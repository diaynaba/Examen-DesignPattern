package com.badwallet.badwallet_api.factory;

import com.badwallet.badwallet_api.entity.PaymentMethod;
import com.badwallet.badwallet_api.strategy.CreditCardStrategy;
import com.badwallet.badwallet_api.strategy.PaymentStrategy;
import com.badwallet.badwallet_api.strategy.WalletStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentStrategyFactory {

    private final CreditCardStrategy creditCardStrategy;

    private final WalletStrategy walletStrategy;

    public PaymentStrategy getStrategy(PaymentMethod method){

        return switch (method){

            case CREDIT_CARD -> creditCardStrategy;

            default -> walletStrategy;

        };

    }

}
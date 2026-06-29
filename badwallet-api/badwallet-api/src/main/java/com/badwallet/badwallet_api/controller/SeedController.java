package com.badwallet.badwallet_api.controller;

import com.badwallet.badwallet_api.entity.Currency;
import com.badwallet.badwallet_api.entity.Wallet;
import com.badwallet.badwallet_api.repository.WalletRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.UUID;

@RestController
@RequestMapping("/api/seed")
@RequiredArgsConstructor
public class SeedController {

    private final WalletRepository walletRepository;

    @PostMapping
    public String seed() {

        for (int i = 1; i <= 5; i++) {

            Wallet wallet = Wallet.builder()
                    .phoneNumber("77000000" + i)
                    .email("user" + i + "@mail.com")
                    .code(UUID.randomUUID().toString().substring(0,8))
                    .currency(Currency.XOF)
                    .balance(BigDecimal.valueOf(100000))
                    .build();

            walletRepository.save(wallet);

        }

        return "5 wallets créés avec succès.";

    }

}
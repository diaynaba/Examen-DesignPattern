package com.badwallet.badwallet_api.controller;

import com.badwallet.badwallet_api.proxy.PaymentProxy;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/external")
@RequiredArgsConstructor
public class ExternalController {

    private final PaymentProxy paymentProxy;

    @GetMapping("/factures/{walletCode}/current")
    public Object current(
            @PathVariable String walletCode) {

        return paymentProxy.currentFactures(walletCode);

    }

    @GetMapping("/factures/{walletCode}/current/unite")
    public Object currentByUnite(
            @PathVariable String walletCode,
            @RequestParam String unite) {

        return paymentProxy.currentFactures(walletCode, unite);

    }

    @GetMapping("/factures/{walletCode}/periode")
    public Object periode(
            @PathVariable String walletCode,
            @RequestParam String debut,
            @RequestParam String fin) {

        return paymentProxy.facturesPeriode(walletCode, debut, fin);

    }

}
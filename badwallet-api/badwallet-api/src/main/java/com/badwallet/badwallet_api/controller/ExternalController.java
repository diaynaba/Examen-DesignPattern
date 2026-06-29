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
    public Object currentFactures(@PathVariable String walletCode){

        return paymentProxy.currentFactures(walletCode);

    }

}
package com.payment.payment_service.controller;

import com.payment.payment_service.dto.response.PaymentResponse;
import com.payment.payment_service.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @GetMapping("/{walletCode}/current")
    public List<PaymentResponse> currentFactures(
            @PathVariable String walletCode) {

        return paymentService.getCurrentFactures(walletCode);

    }

}
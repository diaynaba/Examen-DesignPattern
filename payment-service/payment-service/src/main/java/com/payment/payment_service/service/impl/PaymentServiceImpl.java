package com.payment.payment_service.service.impl;

import com.payment.payment_service.dto.response.PaymentResponse;
import com.payment.payment_service.entity.Payment;
import com.payment.payment_service.repository.PaymentRepository;
import com.payment.payment_service.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    @Override
    public List<PaymentResponse> getCurrentFactures(String walletCode) {

        return paymentRepository.findByWalletCodeAndPaidFalse(walletCode)
                .stream()
                .map(payment -> PaymentResponse.builder()
                        .id(payment.getId())
                        .walletCode(payment.getWalletCode())
                        .serviceName(payment.getServiceName())
                        .factureReference(payment.getFactureReference())
                        .amount(payment.getAmount())
                        .paid(payment.getPaid())
                        .build())
                .toList();

    }

}
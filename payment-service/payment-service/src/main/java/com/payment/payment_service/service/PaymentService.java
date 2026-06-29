package com.payment.payment_service.service;

import com.payment.payment_service.dto.response.PaymentResponse;
import java.util.List;

public interface PaymentService {

    List<PaymentResponse> getCurrentFactures(String walletCode);

}
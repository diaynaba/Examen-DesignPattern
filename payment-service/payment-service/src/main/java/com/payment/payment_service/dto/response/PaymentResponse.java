package com.payment.payment_service.dto.response;

import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentResponse {

    private Long id;
    private String walletCode;
    private String serviceName;
    private String factureReference;
    private BigDecimal amount;
    private Boolean paid;

}
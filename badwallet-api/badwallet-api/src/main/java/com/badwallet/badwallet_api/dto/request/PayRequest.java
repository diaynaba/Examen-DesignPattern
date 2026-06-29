package com.badwallet.badwallet_api.dto.request;

import com.badwallet.badwallet_api.entity.PaymentMethod;
import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PayRequest {

    private String phoneNumber;

    private BigDecimal amount;

    private PaymentMethod paymentMethod;

}
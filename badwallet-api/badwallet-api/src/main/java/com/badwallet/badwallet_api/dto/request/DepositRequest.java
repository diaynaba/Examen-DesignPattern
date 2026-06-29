package com.badwallet.badwallet_api.dto.request;

import com.badwallet.badwallet_api.entity.PaymentMethod;
import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DepositRequest {

    @NotNull
    @DecimalMin("1")
    private BigDecimal amount;

    @NotNull
    private PaymentMethod paymentMethod;

}
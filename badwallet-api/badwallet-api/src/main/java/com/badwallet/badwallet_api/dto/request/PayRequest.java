package com.badwallet.badwallet_api.dto.request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PayRequest {

    @NotBlank
    private String phoneNumber;

    @NotBlank
    private String serviceName;

    @NotNull
    @DecimalMin("0.01")
    private BigDecimal amount;

}
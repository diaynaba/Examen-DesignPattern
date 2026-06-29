package com.badwallet.badwallet_api.dto.request;

import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PayRequest {

    @NotBlank
    private String phoneNumber;

    @NotBlank
    private String serviceName;

    @NotNull
    private BigDecimal amount;

}
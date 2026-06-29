package com.badwallet.badwallet_api.dto.request;

import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WithdrawRequest {

    @NotBlank
    private String phoneNumber;

    @NotNull
    @DecimalMin("1")
    private BigDecimal amount;

}
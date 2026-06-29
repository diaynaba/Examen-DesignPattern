package com.badwallet.badwallet_api.dto.request;

import com.badwallet.badwallet_api.entity.Currency;
import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateWalletRequest {

    @NotBlank
    private String phoneNumber;

    @Email
    @NotBlank
    private String email;

    @NotNull
    @DecimalMin("0.0")
    private BigDecimal initialBalance;

    @NotBlank
    private String code;

    @NotNull
    private Currency currency;

}
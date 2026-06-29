package com.badwallet.badwallet_api.dto.request;

import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransferRequest {

    @NotBlank
    private String senderPhone;

    @NotBlank
    private String receiverPhone;

    @NotNull
    @DecimalMin("1")
    private BigDecimal amount;

}
package com.badwallet.badwallet_api.dto.response;

import com.badwallet.badwallet_api.entity.Currency;
import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WalletResponse {

    private Long id;

    private String code;

    private String phoneNumber;

    private String email;

    private BigDecimal balance;

    private Currency currency;
}
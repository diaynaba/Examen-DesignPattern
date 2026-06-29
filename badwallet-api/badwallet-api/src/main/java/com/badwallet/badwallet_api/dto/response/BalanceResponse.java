package com.badwallet.badwallet_api.dto.response;

import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BalanceResponse {

    private String phoneNumber;

    private BigDecimal balance;
}
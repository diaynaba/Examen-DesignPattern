package com.badwallet.badwallet_api.dto.response;

import com.badwallet.badwallet_api.entity.TransactionStatus;
import com.badwallet.badwallet_api.entity.TransactionType;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionResponse {

    private Long id;

    private TransactionType type;

    private TransactionStatus status;

    private BigDecimal amount;

    private BigDecimal fees;

    private LocalDateTime createdAt;
}
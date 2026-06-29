package com.badwallet.badwallet_api.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TransactionType type;

    @Enumerated(EnumType.STRING)
    private TransactionStatus status;

    private BigDecimal amount;

    private BigDecimal fees;

    @ManyToOne
    @JoinColumn(name = "sender_wallet_id")
    private Wallet sender;

    @ManyToOne
    @JoinColumn(name = "receiver_wallet_id")
    private Wallet receiver;

    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now();
}
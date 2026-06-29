package com.payment.payment_service.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "payments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String walletCode;

    private String serviceName;

    private String reference;

    private BigDecimal amount;

    private String status;

    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now();
}
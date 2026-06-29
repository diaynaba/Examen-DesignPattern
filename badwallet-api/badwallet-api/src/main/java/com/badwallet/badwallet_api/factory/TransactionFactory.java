package com.badwallet.badwallet_api.factory;

import com.badwallet.badwallet_api.entity.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionFactory {

    private TransactionFactory() {
    }

    public static Transaction createDeposit(Wallet wallet, BigDecimal amount) {

        return Transaction.builder()
                .sender(wallet)
                .receiver(wallet)
                .amount(amount)
                .fees(BigDecimal.ZERO)
                .status(TransactionStatus.SUCCESS)
                .type(TransactionType.DEPOSIT)
                .createdAt(LocalDateTime.now())
                .build();

    }

    public static Transaction createWithdraw(
            Wallet wallet,
            BigDecimal amount,
            BigDecimal fees) {

        return Transaction.builder()
                .sender(wallet)
                .receiver(wallet)
                .amount(amount)
                .fees(fees)
                .status(TransactionStatus.SUCCESS)
                .type(TransactionType.WITHDRAW)
                .createdAt(LocalDateTime.now())
                .build();

    }

    public static Transaction createTransfer(
            Wallet sender,
            Wallet receiver,
            BigDecimal amount) {

        return Transaction.builder()
                .sender(sender)
                .receiver(receiver)
                .amount(amount)
                .fees(BigDecimal.ZERO)
                .status(TransactionStatus.SUCCESS)
                .type(TransactionType.TRANSFER)
                .createdAt(LocalDateTime.now())
                .build();

    }

}
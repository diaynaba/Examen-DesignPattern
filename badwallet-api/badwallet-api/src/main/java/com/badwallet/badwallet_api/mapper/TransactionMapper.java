package com.badwallet.badwallet_api.mapper;

import com.badwallet.badwallet_api.dto.response.TransactionResponse;
import com.badwallet.badwallet_api.entity.Transaction;

public class TransactionMapper {

    private TransactionMapper() {
    }

    public static TransactionResponse toResponse(Transaction transaction) {

        return TransactionResponse.builder()
                .id(transaction.getId())
                .type(transaction.getType())
                .status(transaction.getStatus())
                .amount(transaction.getAmount())
                .fees(transaction.getFees())
                .createdAt(transaction.getCreatedAt())
                .build();

    }

}
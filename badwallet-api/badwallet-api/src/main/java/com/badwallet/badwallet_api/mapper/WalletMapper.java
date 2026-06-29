package com.badwallet.badwallet_api.mapper;

import com.badwallet.badwallet_api.dto.response.WalletResponse;
import com.badwallet.badwallet_api.entity.Wallet;

public class WalletMapper {

    private WalletMapper() {
    }

    public static WalletResponse toResponse(Wallet wallet) {
        return WalletResponse.builder()
                .id(wallet.getId())
                .code(wallet.getCode())
                .phoneNumber(wallet.getPhoneNumber())
                .email(wallet.getEmail())
                .balance(wallet.getBalance())
                .currency(wallet.getCurrency())
                .build();
    }

}
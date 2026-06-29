package com.badwallet.badwallet_api.service;

import com.badwallet.badwallet_api.dto.request.*;
import com.badwallet.badwallet_api.dto.response.*;
import org.springframework.data.domain.Page;

import java.util.List;

public interface WalletService {

    WalletResponse createWallet(CreateWalletRequest request);

    Page<WalletResponse> getAllWallets(int page, int size);

    WalletResponse getWalletByPhone(String phone);

    BalanceResponse getBalance(String phone);

    TransactionResponse deposit(Long walletId, DepositRequest request);

    TransactionResponse withdraw(WithdrawRequest request);

    TransactionResponse transfer(TransferRequest request);

    List<TransactionResponse> getHistory(String phone);

    TransactionResponse pay(PayRequest request);

    Object payFactures(PayFacturesRequest request);
    String seed(int numWallets, int eventsPerWallet);

}
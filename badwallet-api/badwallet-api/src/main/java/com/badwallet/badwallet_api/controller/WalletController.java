package com.badwallet.badwallet_api.controller;

import com.badwallet.badwallet_api.dto.request.*;
import com.badwallet.badwallet_api.dto.response.*;
import com.badwallet.badwallet_api.service.WalletService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wallets")
@RequiredArgsConstructor
public class WalletController {

    private final WalletService walletService;

    @PostMapping
    public WalletResponse create(@Valid @RequestBody CreateWalletRequest request) {
        return walletService.createWallet(request);
    }

    @GetMapping
    public Page<WalletResponse> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        return walletService.getAllWallets(page, size);
    }

    @GetMapping("/{phone}")
    public WalletResponse getByPhone(@PathVariable String phone) {
        return walletService.getWalletByPhone(phone);
    }

    @GetMapping("/{phone}/balance")
    public BalanceResponse balance(@PathVariable String phone) {
        return walletService.getBalance(phone);
    }

    @PostMapping("/{walletId}/deposit")
public TransactionResponse deposit(
        @PathVariable Long walletId,
        @RequestBody DepositRequest request) {

    return walletService.deposit(walletId, request);
}

    @PostMapping("/withdraw")
    public TransactionResponse withdraw(@RequestBody WithdrawRequest request) {
        return walletService.withdraw(request);
    }

    @PostMapping("/transfer")
    public TransactionResponse transfer(@RequestBody TransferRequest request) {
        return walletService.transfer(request);
    }

    @GetMapping("/{phone}/history")
    public List<TransactionResponse> history(@PathVariable String phone) {
        return walletService.getHistory(phone);
    }

}
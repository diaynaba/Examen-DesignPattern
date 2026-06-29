package com.badwallet.badwallet_api.service.impl;

import com.badwallet.badwallet_api.dto.request.*;
import com.badwallet.badwallet_api.dto.response.*;
import com.badwallet.badwallet_api.entity.*;
import com.badwallet.badwallet_api.exception.ResourceNotFoundException;
import com.badwallet.badwallet_api.mapper.TransactionMapper;
import com.badwallet.badwallet_api.mapper.WalletMapper;
import com.badwallet.badwallet_api.repository.TransactionRepository;
import com.badwallet.badwallet_api.repository.WalletRepository;
import com.badwallet.badwallet_api.service.WalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WalletServiceImpl implements WalletService {

    private final WalletRepository walletRepository;
    private final TransactionRepository transactionRepository;

    @Override
    public WalletResponse createWallet(CreateWalletRequest request) {

        if (walletRepository.existsByPhoneNumber(request.getPhoneNumber()))
            throw new RuntimeException("Phone déjà utilisé");

        if (walletRepository.existsByEmail(request.getEmail()))
            throw new RuntimeException("Email déjà utilisé");

        if (walletRepository.existsByCode(request.getCode()))
            throw new RuntimeException("Code déjà utilisé");

        Wallet wallet = Wallet.builder()
                .phoneNumber(request.getPhoneNumber())
                .email(request.getEmail())
                .code(request.getCode())
                .currency(request.getCurrency())
                .balance(request.getInitialBalance())
                .createdAt(LocalDateTime.now())
                .build();

        walletRepository.save(wallet);

        return WalletMapper.toResponse(wallet);
    }

    @Override
    public Page<WalletResponse> getAllWallets(int page, int size) {

        return walletRepository.findAll(PageRequest.of(page, size))
                .map(WalletMapper::toResponse);

    }

    @Override
    public WalletResponse getWalletByPhone(String phone) {

        Wallet wallet = walletRepository.findByPhoneNumber(phone)
                .orElseThrow(() -> new ResourceNotFoundException("Wallet introuvable"));

        return WalletMapper.toResponse(wallet);

    }

    @Override
    public BalanceResponse getBalance(String phone) {

        Wallet wallet = walletRepository.findByPhoneNumber(phone)
                .orElseThrow(() -> new ResourceNotFoundException("Wallet introuvable"));

        return BalanceResponse.builder()
                .phoneNumber(wallet.getPhoneNumber())
                .balance(wallet.getBalance())
                .build();

    }

    @Override
    public TransactionResponse deposit(Long walletId, DepositRequest request) {

        Wallet wallet = walletRepository.findById(walletId)
                .orElseThrow(() -> new ResourceNotFoundException("Wallet introuvable"));

        wallet.setBalance(wallet.getBalance().add(request.getAmount()));

        walletRepository.save(wallet);

        Transaction transaction = Transaction.builder()
                .sender(wallet)
                .amount(request.getAmount())
                .fees(BigDecimal.ZERO)
                .type(TransactionType.DEPOSIT)
                .status(TransactionStatus.SUCCESS)
                .createdAt(LocalDateTime.now())
                .build();

        transactionRepository.save(transaction);

        return TransactionMapper.toResponse(transaction);
    }    @Override
    public TransactionResponse withdraw(WithdrawRequest request) {

        Wallet wallet = walletRepository.findByPhoneNumber(request.getPhoneNumber())
                .orElseThrow(() -> new ResourceNotFoundException("Wallet introuvable"));

        BigDecimal fees = request.getAmount().multiply(BigDecimal.valueOf(0.01));

        if (fees.compareTo(BigDecimal.valueOf(5000)) > 0) {
            fees = BigDecimal.valueOf(5000);
        }

        BigDecimal total = request.getAmount().add(fees);

        if (wallet.getBalance().compareTo(total) < 0) {
            throw new RuntimeException("Solde insuffisant");
        }

        wallet.setBalance(wallet.getBalance().subtract(total));

        walletRepository.save(wallet);

        Transaction transaction = Transaction.builder()
                .sender(wallet)
                .amount(request.getAmount())
                .fees(fees)
                .type(TransactionType.WITHDRAW)
                .status(TransactionStatus.SUCCESS)
                .createdAt(LocalDateTime.now())
                .build();

        transactionRepository.save(transaction);

        return TransactionMapper.toResponse(transaction);
    }

    @Override
    public TransactionResponse transfer(TransferRequest request) {

        Wallet sender = walletRepository.findByPhoneNumber(request.getSenderPhone())
                .orElseThrow(() -> new ResourceNotFoundException("Expéditeur introuvable"));

        Wallet receiver = walletRepository.findByPhoneNumber(request.getReceiverPhone())
                .orElseThrow(() -> new ResourceNotFoundException("Destinataire introuvable"));

        if (sender.getBalance().compareTo(request.getAmount()) < 0) {
            throw new RuntimeException("Solde insuffisant");
        }

        sender.setBalance(sender.getBalance().subtract(request.getAmount()));
        receiver.setBalance(receiver.getBalance().add(request.getAmount()));

        walletRepository.save(sender);
        walletRepository.save(receiver);

        Transaction transaction = Transaction.builder()
                .sender(sender)
                .receiver(receiver)
                .amount(request.getAmount())
                .fees(BigDecimal.ZERO)
                .type(TransactionType.TRANSFER)
                .status(TransactionStatus.SUCCESS)
                .createdAt(LocalDateTime.now())
                .build();

        transactionRepository.save(transaction);

        return TransactionMapper.toResponse(transaction);
    }

    @Override
    public List<TransactionResponse> getHistory(String phone) {

        Wallet wallet = walletRepository.findByPhoneNumber(phone)
                .orElseThrow(() -> new ResourceNotFoundException("Wallet introuvable"));

        return transactionRepository
                .findBySenderOrReceiverOrderByCreatedAtDesc(wallet, wallet)
                .stream()
                .map(TransactionMapper::toResponse)
                .toList();
    }

}
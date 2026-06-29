package com.badwallet.badwallet_api.repository;

import com.badwallet.badwallet_api.entity.Transaction;
import com.badwallet.badwallet_api.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findBySenderOrReceiverOrderByCreatedAtDesc(
            Wallet sender,
            Wallet receiver
    );
}
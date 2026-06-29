package com.payment.payment_service.repository;

import com.payment.payment_service.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    List<Payment> findByWalletCode(String walletCode);

    List<Payment> findByWalletCodeAndPaidFalse(String walletCode);

}
package com.sharedexpenses.repository;

import com.sharedexpenses.domain.Payment;
import com.sharedexpenses.domain.dto.PaymentDTO;

import java.util.List;

public interface PaymentRepository {
    List<Payment> getAllPayments();
    Payment addPayment(PaymentDTO payment);
    void deletePayment(long id);
}

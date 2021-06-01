package com.sharedexpenses.usecases;

import com.sharedexpenses.domain.*;
import com.sharedexpenses.domain.dto.PaymentDTO;

import java.util.List;

public interface PaymentUseCase {
    List<Payment> getAllPayments();
    Payment addPayment(PaymentDTO payment);
    void deletePayment(long id);
}


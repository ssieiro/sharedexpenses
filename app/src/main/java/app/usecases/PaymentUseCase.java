package app.usecases;

import domain.Payment;
import domain.dto.PaymentDTO;

import java.util.List;

public interface PaymentUseCase {
    List<Payment> getAllPayments();
    Payment addPayment(PaymentDTO payment);
    void deletePayment(long id);
}


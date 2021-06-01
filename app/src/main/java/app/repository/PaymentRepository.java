package app.repository;


import domain.Payment;

import java.util.List;

public interface PaymentRepository {
    List<Payment> getAllPayments();
    Payment addPayment(Payment payment);
    void deletePayment(long id);
}

package sharedexpenses.app.usecases;

import sharedexpenses.domain.Payment;
import sharedexpenses.domain.dto.PaymentDTO;
import java.util.List;

public interface PaymentUseCase {
    List<Payment> getAllPayments();
    Payment addPayment(PaymentDTO payment);
    void deletePayment(long id);
}


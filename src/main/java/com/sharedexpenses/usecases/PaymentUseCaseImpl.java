package com.sharedexpenses.usecases;

import com.sharedexpenses.domain.*;
import com.sharedexpenses.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PaymentUseCaseImpl implements PaymentUseCase {

    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentUseCaseImpl(PaymentRepository paymentRepository){
        this.paymentRepository = paymentRepository;
    }

    // GET ALL
    @Override
    public List<Payment> getAllPayments() { return paymentRepository.getAllPayments(); }

    //ADD
    @Override
    public Payment addPayment(Payment payment){ return paymentRepository.addPayment(payment); }

    //DELETE
    @Override
    public void deletePayment(long id) { paymentRepository.deletePayment(id);}
}


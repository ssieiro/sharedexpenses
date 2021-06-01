package com.sharedexpenses.repository.mysqlImp;

import com.sharedexpenses.domain.Payment;
import com.sharedexpenses.domain.dto.PaymentDTO;
import com.sharedexpenses.repository.PaymentRepository;
import com.sharedexpenses.repository.mysqlImp.mappers.PaymentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MysqlPaymentRepositoryImpl implements PaymentRepository {

    private final PaymentMapper paymentMapper;

    @Autowired
    public MysqlPaymentRepositoryImpl(PaymentMapper paymentMapper){
        this.paymentMapper = paymentMapper;
    }

    //GET ALL
    @Override
    public List<Payment> getAllPayments() { return paymentMapper.findAllPayments(); }

    //ADD
    @Override
    public Payment addPayment(PaymentDTO payment) {
        paymentMapper.insertPayment(payment);
        return paymentMapper.findPaymentById(payment.getId());
    }

    //DELETE
    @Override
    public void deletePayment(long id) { paymentMapper.deletePaymentById(id);}
}

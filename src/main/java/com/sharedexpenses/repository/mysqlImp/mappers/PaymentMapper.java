package com.sharedexpenses.repository.mysqlImp.mappers;

import com.sharedexpenses.domain.Payment;
import com.sharedexpenses.domain.PaymentDTO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PaymentMapper {

    //SELECT ALL
    List findAllPayments();

    //SELECT BY ID
    Payment findPaymentById(long id);

    //INSERT
    void insertPayment(PaymentDTO payment);

    //DELETE
    void deletePaymentById(long id);
}

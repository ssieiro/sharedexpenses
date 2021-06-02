package sharedexpenses.app.repository.mysqlImp.mappers;

import sharedexpenses.domain.Payment;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PaymentMapper {

    //SELECT ALL
    List findAllPayments();

    //SELECT BY ID
    Payment findPaymentById(long id);

    //INSERT
    void insertPayment(Payment payment);

    //DELETE
    void deletePaymentById(long id);
}

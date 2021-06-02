package sharedexpenses.app.repository.mysqlImp;

import sharedexpenses.app.repository.PaymentRepository;
import sharedexpenses.app.repository.mysqlImp.mappers.PaymentMapper;
import sharedexpenses.domain.Payment;
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
    public Payment addPayment(Payment payment) {
        paymentMapper.insertPayment(payment);
        return paymentMapper.findPaymentById(payment.getId());
    }

    //DELETE
    @Override
    public void deletePayment(long id) { paymentMapper.deletePaymentById(id);}
}

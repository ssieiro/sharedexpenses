package app.repository.mappers;

import app.repository.mysqlImp.mappers.PaymentMapper;
import domain.Friend;
import domain.FriendsGroup;
import domain.Payment;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


@SpringBootTest
public class PaymentMapperIT {

    @Autowired
    PaymentMapper paymentMapper;

    ////SELECT ALL
    @Test
    public void shouldGetAllPayments(){
        List<Payment> payments = paymentMapper.findAllPayments();
        MatcherAssert.assertThat(payments.get(0).getConcept(), is("pago prueba 1"));
        MatcherAssert.assertThat(payments.get(1).getConcept(), is("pago prueba 2"));
    }

    //SELECT BY ID
    @Test
    public void shouldGetPaymentById(){
        Payment payment = paymentMapper.findPaymentById(1);
        MatcherAssert.assertThat(payment.getConcept(), is("pago prueba 1"));
    }

    //INSERT AND DELETE
    @Test
    public void shouldInsertAndDeletePayment(){
        paymentMapper.insertPayment(new Payment(1, "Payment test", BigDecimal.valueOf(20),
                new Friend(1, "Sonia",
                new FriendsGroup(1, "Prueba")), LocalDateTime.now()));
        List<Payment> paymentssAfterInsert = paymentMapper.findAllPayments();
        assertThat(paymentssAfterInsert.size(), is(3));
        paymentMapper.deletePaymentById(3);
        List<Payment> paymentsAfteDelete = paymentMapper.findAllPayments();
        assertThat(paymentsAfteDelete.size(), is(2));
    }

}

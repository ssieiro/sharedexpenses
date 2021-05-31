package com.sharedexpenses.repository;

import com.sharedexpenses.domain.Payment;
import com.sharedexpenses.repository.mysqlImp.MysqlPaymentRepositoryImpl;
import com.sharedexpenses.repository.mysqlImp.mappers.PaymentMapper;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/*
public class PaymentRepositoryTest {
    private final PaymentMapper paymentMapper = mock(PaymentMapper.class);
    private final PaymentRepository paymentRepository = new MysqlPaymentRepositoryImpl(paymentMapper);
    private final LocalDateTime date = LocalDateTime.now();

    @Test
    public void shouldGetAllPayments() {
        List<Payment> expectedPayments = List.of(new Payment("pago1", BigDecimal.valueOf(20.0), 2, date));
        when(paymentMapper.findAllPayments()).thenReturn(expectedPayments);
        List<Payment> paymentsList = paymentRepository.getAllPayments();
        assertThat(paymentsList, is(expectedPayments));
    }
}*/

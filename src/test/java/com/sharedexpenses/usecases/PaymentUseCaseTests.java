package com.sharedexpenses.usecases;

import com.sharedexpenses.domain.*;
import com.sharedexpenses.repository.PaymentRepository;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/*
public class PaymentUseCaseTests {
    private final PaymentRepository paymentRepository = mock(PaymentRepository.class);
    private final PaymentUseCase paymentUseCase = new PaymentUseCaseImpl(paymentRepository);
    private final LocalDateTime date = LocalDateTime.now();
    private final List<Payment> expectedPayments = List.of(new Payment("pago1", BigDecimal.valueOf(20.0), 2, date));


    @Test
    public void shouldAllPayments() {
        when(paymentRepository.getAllPayments()).thenReturn(expectedPayments);
        List<Payment> paymentsList = paymentUseCase.getAllPayments();
        assertThat(paymentsList, is(expectedPayments));
    }

    @Test
    public void shouldAddPayment() {
        Payment expectedPayment = new Payment("pago1", BigDecimal.valueOf(20.0), 1, date);
        when(paymentRepository.addPayment(expectedPayment)).thenReturn(expectedPayment);
        Payment payment = paymentRepository.addPayment(expectedPayment);
        assertThat(payment, is(expectedPayment));
    }
}*/
package com.sharedexpenses.restservice;

import com.sharedexpenses.domain.*;
import com.sharedexpenses.usecases.PaymentUseCase;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/*
class PaymentControllerTest {
    private final PaymentUseCase paymentUseCase = mock(PaymentUseCase.class);
    private final PaymentController paymentController = new PaymentController(paymentUseCase);
    private final LocalDateTime date = LocalDateTime.now();
    private final List<Payment> expectedPayments = List.of(new Payment("pago1", BigDecimal.valueOf(20.0), 2, date));

    @Test
    public void shouldGetAllPayments() {
        when(paymentUseCase.getAllPayments()).thenReturn(expectedPayments);
        List<Payment> paymentsList = paymentController.getAllPayments();
        assertThat(paymentsList, is(expectedPayments));
    }


    @Test
    public void shouldAddPayment(){
        Payment expectedPayment = new Payment("pago1", BigDecimal.valueOf(20.0), 1, date);
        when(paymentUseCase.addPayment(expectedPayment)).thenReturn(expectedPayment);
        Payment payment = paymentController.addPayment(expectedPayment);
        assertThat(payment, is(expectedPayment));
        }

}*/
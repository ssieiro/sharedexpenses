package com.sharedexpenses.usecases;

import com.sharedexpenses.domain.*;
import com.sharedexpenses.domain.dto.PaymentDTO;
import com.sharedexpenses.repository.PaymentRepository;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class PaymentUseCaseTests {
    private final PaymentRepository paymentRepository = mock(PaymentRepository.class);
    private final PaymentUseCase paymentUseCase = new PaymentUseCaseImpl(paymentRepository);
    private final LocalDateTime date = LocalDateTime.now();

    @Test
    public void shouldAllPayments() {
        List<Payment> expectedPayments = List.of(new Payment(1, "pago1", BigDecimal.valueOf(20.0), new Friend(2, "Paco", new FriendsGroup("Grupo prueba")), date));
        when(paymentRepository.getAllPayments()).thenReturn(expectedPayments);
        List<Payment> paymentsList = paymentUseCase.getAllPayments();
        assertThat(paymentsList, is(expectedPayments));
    }

    @Test
    public void shouldAddPayment() {
        Payment expectedPayment = new Payment(1, "pago1", BigDecimal.valueOf(20.0), new Friend (1, "Sonia", new FriendsGroup("Grupo prueba", 1)), date);
        PaymentDTO paymentDTO = new PaymentDTO(1, "pago1", BigDecimal.valueOf(20.0), 1, date);
        when(paymentRepository.addPayment(paymentDTO)).thenReturn(expectedPayment);
        Payment payment = paymentRepository.addPayment(paymentDTO);
        assertThat(payment, is(expectedPayment));
    }
}
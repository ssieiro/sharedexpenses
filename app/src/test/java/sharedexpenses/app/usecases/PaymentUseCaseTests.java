package sharedexpenses.app.usecases;

import sharedexpenses.app.repository.FriendRepository;
import sharedexpenses.app.repository.PaymentRepository;
import sharedexpenses.domain.Friend;
import sharedexpenses.domain.FriendsGroup;
import sharedexpenses.domain.Payment;
import sharedexpenses.domain.dto.PaymentDTO;
import org.junit.jupiter.api.Disabled;
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
    private final FriendRepository friendRepository = mock(FriendRepository.class);
    private final PaymentUseCase paymentUseCase = new PaymentUseCaseImpl(paymentRepository, friendRepository);
    private final LocalDateTime date = LocalDateTime.now();

    @Test
    public void shouldGetAllPayments() {
        List<Payment> expectedPayments = List.of(new Payment(1, "pago1", BigDecimal.valueOf(20.0), new Friend(2, "Paco", new FriendsGroup("Grupo prueba")), date));
        when(paymentRepository.getAllPayments()).thenReturn(expectedPayments);
        List<Payment> paymentsList = paymentUseCase.getAllPayments();
        assertThat(paymentsList, is(expectedPayments));
    }

    @Test
    public void shouldAddPayment() {
        PaymentDTO paymentDTO = new PaymentDTO(1, "pago1", BigDecimal.valueOf(20.0), 1, date);
        Payment expectedPayment = new Payment(1, "pago1", BigDecimal.valueOf(20.0), new Friend (1, "Sonia", new FriendsGroup(1,"Grupo prueba")), date);
        when(friendRepository.getFriendById(1)).thenReturn(new Friend (1, "Sonia", new FriendsGroup(1,"Grupo prueba")));
        when(paymentRepository.addPayment(expectedPayment)).thenReturn(expectedPayment);
        Payment payment = paymentUseCase.addPayment(paymentDTO);
        assertThat(payment, is(expectedPayment));
    }

}
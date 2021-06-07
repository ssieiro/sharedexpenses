package sharedexpenses.app.restservice;

import sharedexpenses.app.usecases.PaymentUseCase;
import sharedexpenses.domain.Friend;
import sharedexpenses.domain.FriendsGroup;
import sharedexpenses.domain.Payment;
import sharedexpenses.domain.dto.PaymentDTO;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PaymentControllerTest {
    private final PaymentUseCase paymentUseCase = mock(PaymentUseCase.class);
    private final PaymentController paymentController = new PaymentController(paymentUseCase);
    private final LocalDateTime date = LocalDateTime.now();


    @Test
    public void shouldGetAllPayments() {
        List<Payment> expectedPayments = List.of(new Payment(1, "pago1", BigDecimal.valueOf(20.0), new Friend(2, "Paco", new FriendsGroup(1,"Grupo prueba")), date));
        List<PaymentDTO> expectedPaymentsDTO = List.of(new PaymentDTO(1, "pago1", BigDecimal.valueOf(20.0), 2, date));
        when(paymentUseCase.getAllPayments()).thenReturn(expectedPayments);
        List<PaymentDTO> paymentsList = paymentController.getAllPayments();
        assertThat(paymentsList, is(expectedPaymentsDTO));
    }


    @Test
    public void shouldAddPayment(){
        Payment expectedPayment = new Payment(1, "pago1", BigDecimal.valueOf(20.0), new Friend (1, "Sonia", new FriendsGroup(1,"Grupo prueba")), date);
        PaymentDTO expectedPaymentDTO = new PaymentDTO(1, "pago1", BigDecimal.valueOf(20.0), 1, date);
        when(paymentUseCase.addPayment(expectedPaymentDTO)).thenReturn(expectedPayment);
        PaymentDTO paymentDTO = paymentController.addPayment(expectedPaymentDTO);
        assertThat(paymentDTO, Matchers.is(expectedPaymentDTO));
        }

}
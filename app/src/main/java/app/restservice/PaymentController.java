package app.restservice;

import domain.Payment;
import domain.converters.PaymentConverter;
import domain.dto.PaymentDTO;
import app.usecases.PaymentUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class PaymentController {

    private final PaymentUseCase paymentUseCase;

    @Autowired
    public PaymentController(PaymentUseCase paymentUseCase) {
        this.paymentUseCase = paymentUseCase;
    }

    // GET ALL
    @GetMapping("/payments")
    public List<PaymentDTO> getAllPayments(){
        List<Payment> payments = paymentUseCase.getAllPayments();
        List<PaymentDTO> paymentsDTO = new ArrayList<>();
        payments.forEach(payment -> {
            paymentsDTO.add(PaymentConverter.toDTO(payment));
        });
        return paymentsDTO;
    }

    //POST
    @PostMapping("/payments")
    public PaymentDTO addPayment (@RequestBody PaymentDTO paymentDTO) {
        Payment payment = paymentUseCase.addPayment(paymentDTO);
        return PaymentConverter.toDTO(payment);
    }

    //DELETE
    @DeleteMapping("/payments/{id}")
    public void deletePayment (@PathVariable long id) {
        paymentUseCase.deletePayment(id);
    }

}

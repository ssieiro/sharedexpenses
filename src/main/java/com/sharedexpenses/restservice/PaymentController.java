package com.sharedexpenses.restservice;

import com.sharedexpenses.domain.*;
import com.sharedexpenses.domain.converters.PaymentToDTO;
import com.sharedexpenses.domain.dto.PaymentDTO;
import com.sharedexpenses.usecases.PaymentUseCase;
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
            paymentsDTO.add(PaymentToDTO.convert(payment));
        });
        return paymentsDTO;
    }

    //POST
    @PostMapping("/payments")
    public PaymentDTO addPayment (@RequestBody PaymentDTO paymentDTO) {
        Payment payment = paymentUseCase.addPayment(paymentDTO);
        return PaymentToDTO.convert(payment);
    }

    //DELETE
    @DeleteMapping("/payments/{id}")
    public void deletePayment (@PathVariable long id) {
        paymentUseCase.deletePayment(id);
    }

}

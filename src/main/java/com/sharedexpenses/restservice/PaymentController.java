package com.sharedexpenses.restservice;

import com.sharedexpenses.domain.*;
import com.sharedexpenses.usecases.PaymentUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public List<Payment> getAllPayments(){
        return paymentUseCase.getAllPayments();
    }

    //POST
    @PostMapping("/payments")
    public Payment addPayment (@RequestBody Payment payment) {
        return paymentUseCase.addPayment(payment);
    }

    //DELETE
    @DeleteMapping("/payments/{id}")
    public void deletePayment (@PathVariable long id) {
        paymentUseCase.deletePayment(id);
    }

}

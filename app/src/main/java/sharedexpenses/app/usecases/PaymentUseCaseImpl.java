package sharedexpenses.app.usecases;

import sharedexpenses.domain.Friend;
import sharedexpenses.domain.Payment;
import sharedexpenses.app.repository.FriendRepository;
import sharedexpenses.app.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sharedexpenses.domain.converters.PaymentConverter;
import sharedexpenses.domain.dto.PaymentDTO;

import java.util.List;

@Service
public class PaymentUseCaseImpl implements PaymentUseCase {

    private final PaymentRepository paymentRepository;
    private final FriendRepository friendRepository;

    @Autowired
    public PaymentUseCaseImpl(PaymentRepository paymentRepository, FriendRepository friendRepository){
        this.paymentRepository = paymentRepository;
        this.friendRepository = friendRepository;
    }

    // GET ALL
    @Override
    public List<Payment> getAllPayments() { return paymentRepository.getAllPayments(); }

    //ADD
    @Override
    public Payment addPayment(PaymentDTO paymentDTO){
        Friend friend = friendRepository.getFriendById(paymentDTO.getFriendId());
        Payment payment = PaymentConverter.toPayment(paymentDTO, friend);
        return paymentRepository.addPayment(payment);
    }

    //DELETE
    @Override
    public void deletePayment(long id) { paymentRepository.deletePayment(id);}
}


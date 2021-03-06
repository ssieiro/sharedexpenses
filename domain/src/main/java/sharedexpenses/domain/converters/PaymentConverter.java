package sharedexpenses.domain.converters;

import sharedexpenses.domain.Friend;
import sharedexpenses.domain.Payment;
import sharedexpenses.domain.dto.PaymentDTO;

public class PaymentConverter {
    public static final PaymentDTO toDTO(Payment payment){
        return new PaymentDTO(payment.getId(), payment.getConcept(), payment.getAmount(), payment.getFriend().getId(), payment.getDate());
    }
    public static final Payment toPayment(PaymentDTO payment, Friend friend){
        return new Payment(payment.getId(), payment.getConcept(), payment.getAmount(), friend, payment.getDate());
    }
}

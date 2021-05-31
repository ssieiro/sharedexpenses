package com.sharedexpenses.domain.converters;

import com.sharedexpenses.domain.Payment;
import com.sharedexpenses.domain.PaymentDTO;

public class PaymentToDTO {
    public static final PaymentDTO convert (Payment payment){
        return new PaymentDTO(payment.getId(), payment.getConcept(), payment.getAmount(), payment.getFriend().getId(), payment.getDate());
    }
}

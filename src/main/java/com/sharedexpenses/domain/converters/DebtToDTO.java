package com.sharedexpenses.domain.converters;

import com.sharedexpenses.domain.Debt;
import com.sharedexpenses.domain.dto.DebtDTO;

public class DebtToDTO {
    public static final DebtDTO convert (Debt debt){
        return new DebtDTO(FriendToDTO.convert(debt.getFrom()), FriendToDTO.convert(debt.getTo()), debt.getAmount());
    }
}

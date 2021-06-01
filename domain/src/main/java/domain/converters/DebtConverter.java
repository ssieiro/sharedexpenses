package domain.converters;

import domain.Debt;
import domain.dto.DebtDTO;

public class DebtConverter {
    public static final DebtDTO toDTO(Debt debt){
        return new DebtDTO(FriendConverter.toDTO(debt.getFrom()), FriendConverter.toDTO(debt.getTo()), debt.getAmount());
    }
}

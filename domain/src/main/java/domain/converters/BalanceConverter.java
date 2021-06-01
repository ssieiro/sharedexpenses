package domain.converters;

import domain.Balance;
import domain.dto.BalanceDTO;

public class BalanceConverter {
    public static final BalanceDTO toDTO(Balance balance){
        return new BalanceDTO(balance.getBalance(), FriendConverter.toDTO(balance.getFriend()));
    }
}

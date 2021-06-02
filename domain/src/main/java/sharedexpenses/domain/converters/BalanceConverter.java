package sharedexpenses.domain.converters;

import sharedexpenses.domain.Balance;
import sharedexpenses.domain.dto.BalanceDTO;

public class BalanceConverter {
    public static final BalanceDTO toDTO(Balance balance){
        return new BalanceDTO(balance.getBalance(), FriendConverter.toDTO(balance.getFriend()));
    }
}

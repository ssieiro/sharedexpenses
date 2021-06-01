package com.sharedexpenses.domain.converters;

import com.sharedexpenses.domain.Balance;
import com.sharedexpenses.domain.dto.BalanceDTO;

public class BalanceConverter {
    public static final BalanceDTO toDTO(Balance balance){
        return new BalanceDTO(balance.getBalance(), FriendConverter.toDTO(balance.getFriend()));
    }
}

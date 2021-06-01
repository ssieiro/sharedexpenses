package com.sharedexpenses.domain.converters;

import com.sharedexpenses.domain.Balance;
import com.sharedexpenses.domain.dto.BalanceDTO;

public class BalanceToDTO {
    public static final BalanceDTO convert (Balance balance){
        return new BalanceDTO(balance.getBalance(), FriendToDTO.convert(balance.getFriend()));
    }
}

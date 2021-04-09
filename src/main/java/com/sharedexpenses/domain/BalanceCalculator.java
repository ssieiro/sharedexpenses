package com.sharedexpenses.domain;

import com.sharedexpenses.domain.datamodels.Balance;
import com.sharedexpenses.domain.datamodels.FriendsGroup;

import java.util.List;

public interface BalanceCalculator {
    List<Balance> calculateBalance(FriendsGroup friendsGroup);
}

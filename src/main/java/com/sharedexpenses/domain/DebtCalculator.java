package com.sharedexpenses.domain;

import com.sharedexpenses.domain.datamodels.Debt;
import com.sharedexpenses.domain.datamodels.FriendsGroup;

import java.util.List;

public interface DebtCalculator {
    List<Debt> calculateDebts(FriendsGroup friendsGroup);
}

package com.sharedexpenses.domain;

import com.sharedexpenses.domain.datamodels.Debt;
import com.sharedexpenses.domain.datamodels.Friend;
import com.sharedexpenses.domain.datamodels.FriendsGroup;
import com.sharedexpenses.domain.datamodels.Payment;

import java.util.List;

public interface DebtCalculator {
    List<Debt> calculateDebts(List<Payment> payments, List<Friend> friends);
}

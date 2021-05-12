package com.sharedexpenses.domain;

import com.sharedexpenses.domain.datamodels.Balance;
import com.sharedexpenses.domain.datamodels.Friend;
import com.sharedexpenses.domain.datamodels.Payment;

import java.util.List;

public interface BalanceCalculator {
    List<Balance> calculateBalance(List<Payment> payments, List<Friend> friends);
}

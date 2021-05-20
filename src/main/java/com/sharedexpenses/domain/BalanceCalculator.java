package com.sharedexpenses.domain;

import java.util.List;

public interface BalanceCalculator {
    List<Balance> calculateBalance(List<Payment> payments, List<Friend> friends);
}

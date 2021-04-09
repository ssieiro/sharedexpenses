package com.sharedexpenses.domain.calculatorsfirstimplementation;

import com.sharedexpenses.domain.BalanceCalculator;
import com.sharedexpenses.domain.BalanceCalculatorFactory;
import com.sharedexpenses.domain.DebtCalculator;
import com.sharedexpenses.domain.datamodels.Balance;
import com.sharedexpenses.domain.datamodels.Debt;
import com.sharedexpenses.domain.datamodels.FriendsGroup;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DebtCalculatorFirstImplementation implements DebtCalculator {
    public List<Debt> calculateDebts(FriendsGroup friendsGroup) {
        BalanceCalculator balanceCalculator = BalanceCalculatorFactory.getInstance();
        List<Balance> balanceList = balanceCalculator.calculateBalance(friendsGroup);

        List<Debt> debtsList = new ArrayList<>();

        while (!balanceList.isEmpty()) {
            balanceList.sort(Collections.reverseOrder());
            Balance firstBalance = balanceList.get(0);
            Balance lastBalance = balanceList.get(balanceList.size()-1);
            BigDecimal firstBalanceAmount = firstBalance.getBalance();
            BigDecimal lastBalanceAmount = lastBalance.getBalance();
            balanceList.remove(firstBalance);
            balanceList.remove(lastBalance);

            Debt debt = new Debt(firstBalance.getFriend(), lastBalance.getFriend(), firstBalanceAmount);
            debtsList.add(debt);
            firstBalance = new Balance(firstBalanceAmount.subtract(firstBalanceAmount), firstBalance.getFriend());
            lastBalance = new Balance(lastBalanceAmount.add(firstBalanceAmount), lastBalance.getFriend());

            if (isNotAlmostZero(firstBalance.getBalance())) {
                balanceList.add(firstBalance);
            }
            if (isNotAlmostZero(lastBalance.getBalance())) {
                balanceList.add(lastBalance);
            }
        }

        return debtsList;
    }

    public boolean isNotAlmostZero(BigDecimal value) {
        return (value.compareTo(BigDecimal.valueOf(-0.02)) < 0) || (value.compareTo(BigDecimal.valueOf(0.02)) > 0);
    }
}

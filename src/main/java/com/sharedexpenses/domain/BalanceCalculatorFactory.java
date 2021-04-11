package com.sharedexpenses.domain;

import com.sharedexpenses.domain.calculatorsfirstimpl.BalanceCalculatorFirstImpl;

public class BalanceCalculatorFactory {
    public static BalanceCalculator getInstance(){
        return new BalanceCalculatorFirstImpl();
    }
}

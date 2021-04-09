package com.sharedexpenses.domain;

import com.sharedexpenses.domain.calculatorsfirstimplementation.BalanceCalculatorFirstImplementation;

public class BalanceCalculatorFactory {
    public static BalanceCalculator getInstance(){
        return new BalanceCalculatorFirstImplementation();
    }
}

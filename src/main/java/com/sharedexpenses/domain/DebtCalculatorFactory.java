package com.sharedexpenses.domain;

import com.sharedexpenses.domain.calculatorsfirstimpl.DebtCalculatorFirstImpl;

public class DebtCalculatorFactory {
    public static DebtCalculator getInstance(){
        return new DebtCalculatorFirstImpl();
    }
}

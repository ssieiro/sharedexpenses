package com.sharedexpenses.domain;

import com.sharedexpenses.domain.calculatorsfirstimplementation.DebtCalculatorFirstImplementation;

public class DebtCalculatorFactory {
    public static DebtCalculator getInstance(){
        return new DebtCalculatorFirstImplementation();
    }
}

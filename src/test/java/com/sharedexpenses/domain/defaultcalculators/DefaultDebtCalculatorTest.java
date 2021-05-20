package com.sharedexpenses.domain.defaultcalculators;

import com.sharedexpenses.domain.*;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class DefaultDebtCalculatorTest {

    BalanceCalculator balanceCalculator = new DefaultBalanceCalculator();
    DebtCalculator debtCalculator = new DefaultDebtCalculator(balanceCalculator);
    Friend friendSonia = new Friend("Sonia",1, 1);
    Friend friendPaco = new Friend("Paco",1, 2);
    Friend friendAlba = new Friend("Alba",1, 3);

    @Test
    public void shouldSettleOneDebtAndTwoFriends(){
        Payment payment = new Payment("concepto test", BigDecimal.valueOf(20), 1, LocalDateTime.now());
        List<Debt> debts = debtCalculator.calculateDebts(List.of(payment), List.of(friendSonia, friendPaco));
        assertThat(debts, is(List.of(new Debt(new Friend("Paco",1,  2), new Friend("Sonia",1, 1), BigDecimal.valueOf(10).setScale(2)))));
    }

    @Test
    public void shouldSettleOneDebtWithThreeFriends(){
        Payment payment = new Payment("concepto test", BigDecimal.valueOf(15), 1, LocalDateTime.now());
        List<Debt> debts = debtCalculator.calculateDebts(List.of(payment), List.of(friendSonia, friendPaco, friendAlba));

        assertThat(debts, is(List.of(new Debt(new Friend("Paco",1, 2), new Friend("Sonia",1, 1), BigDecimal.valueOf(5).setScale(2)),
                new Debt(new Friend("Alba",1, 3), new Friend("Sonia",1, 1), BigDecimal.valueOf(5).setScale(2)))));
    }

    @Test
    public void shouldSettleDebtsWithDecimals(){
        Payment payment = new Payment("concepto test", BigDecimal.valueOf(15.3), 1, LocalDateTime.now());
        Payment payment2 = new Payment("concepto test", BigDecimal.valueOf(45.3), 3, LocalDateTime.now());

        List<Debt> debts = debtCalculator.calculateDebts(List.of(payment, payment2), List.of(friendSonia, friendPaco, friendAlba));

        assertThat(debts, is(List.of(new Debt(new Friend("Paco", 1, 2), new Friend("Alba", 1, 3), BigDecimal.valueOf(20.20).setScale(2)),
                new Debt(new Friend("Sonia",1, 1), new Friend("Alba", 1, 3), BigDecimal.valueOf(4.90).setScale(2)))));

    }

    @Test
    public void shouldSettleNotRoundNumbers(){
        Payment payment = new Payment("concepto test", BigDecimal.valueOf(10), 1, LocalDateTime.now());

        List<Debt> debts = debtCalculator.calculateDebts(List.of(payment), List.of(friendSonia, friendPaco, friendAlba));
        assertThat(debts, is(List.of(new Debt(new Friend("Paco",1, 2), new Friend("Sonia",1, 1), BigDecimal.valueOf(3.34).setScale(2)),
                new Debt(new Friend("Alba",1, 3), new Friend("Sonia",1, 1), BigDecimal.valueOf(3.34).setScale(2)))));
    }

}

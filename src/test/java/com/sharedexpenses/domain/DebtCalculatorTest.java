package com.sharedexpenses.domain;

import com.sharedexpenses.domain.datamodels.Debt;
import com.sharedexpenses.domain.datamodels.Friend;
import com.sharedexpenses.domain.datamodels.FriendsGroup;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class DebtCalculatorTest {
    DebtCalculator debtCalculator = DebtCalculatorFactory.getInstance();
    FriendsGroup group = new FriendsGroup("Grupo de test");

    @Test
    public void shouldSettleOneDebtAndTwoFriends(){
        group.addFriend("Sonia");
        group.addFriend("Paco");
        group.addPayment("prueba", BigDecimal.valueOf(20), "Sonia", LocalDateTime.now());
        List<Debt> debts = debtCalculator.calculateDebts(group);
        assertThat(debts, is(List.of(new Debt(new Friend("Paco"), new Friend("Sonia"), BigDecimal.valueOf(10).setScale(2)))));
    }

    @Test
    public void shouldSettleOneDebtWithThreeFriends(){
        group.addFriend("Sonia");
        group.addFriend("Paco");
        group.addFriend("Alba");
        group.addPayment("prueba", BigDecimal.valueOf(15), "Sonia", LocalDateTime.now());

        assertThat(debtCalculator.calculateDebts(group), is(List.of(new Debt(new Friend("Paco"), new Friend("Sonia"), BigDecimal.valueOf(5).setScale(2)),
                new Debt(new Friend("Alba"), new Friend("Sonia"), BigDecimal.valueOf(5).setScale(2)))));
    }

    @Test
    public void shouldSettleDebtsWithDecimals(){
        group.addFriend("Sonia");
        group.addFriend("Paco");
        group.addFriend("Alba");
        group.addPayment("prueba", BigDecimal.valueOf(15.3), "Sonia", LocalDateTime.now());
        group.addPayment("prueba", BigDecimal.valueOf(45.3), "Alba", LocalDateTime.now());

        assertThat(debtCalculator.calculateDebts(group), is(List.of(new Debt(new Friend("Paco"), new Friend("Alba"), BigDecimal.valueOf(20.20).setScale(2)),
                new Debt(new Friend("Sonia"), new Friend("Alba"), BigDecimal.valueOf(4.90).setScale(2)))));

    }

    @Test
    public void shouldSettleNotRoundNumbers(){
        group.addFriend("Sonia");
        group.addFriend("Paco");
        group.addFriend("Alba");
        group.addPayment("prueba", BigDecimal.valueOf(10), "Sonia", LocalDateTime.now());

        assertThat(debtCalculator.calculateDebts(group), is(List.of(new Debt(new Friend("Paco"), new Friend("Sonia"), BigDecimal.valueOf(3.34).setScale(2)),
                new Debt(new Friend("Alba"), new Friend("Sonia"), BigDecimal.valueOf(3.34).setScale(2)))));
    }

}

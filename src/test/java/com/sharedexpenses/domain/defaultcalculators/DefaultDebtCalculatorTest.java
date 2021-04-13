package com.sharedexpenses.domain.defaultcalculators;

import com.sharedexpenses.domain.BalanceCalculator;
import com.sharedexpenses.domain.DebtCalculator;
import com.sharedexpenses.domain.datamodels.Debt;
import com.sharedexpenses.domain.datamodels.Friend;
import com.sharedexpenses.domain.datamodels.FriendsGroup;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class DefaultDebtCalculatorTest {

    BalanceCalculator balanceCalculator = new DefaultBalanceCalculator();
    DebtCalculator debtCalculator = new DefaultDebtCalculator(balanceCalculator);
    FriendsGroup group = new FriendsGroup("Grupo de test");

    @Test
    public void shouldSettleOneDebtAndTwoFriends(){
        group.addFriend("Sonia");
        group.addFriend("Paco");
        group.addPayment("prueba", BigDecimal.valueOf(20), group.getFriendByName("Sonia"), LocalDateTime.now());
        List<Debt> debts = debtCalculator.calculateDebts(group);
        assertThat(debts, is(List.of(new Debt(new Friend("Paco"), new Friend("Sonia"), BigDecimal.valueOf(10).setScale(2)))));
    }

    @Test
    public void shouldSettleOneDebtWithThreeFriends(){
        group.addFriend("Sonia");
        group.addFriend("Paco");
        group.addFriend("Alba");
        group.addPayment("prueba", BigDecimal.valueOf(15), group.getFriendByName("Sonia"), LocalDateTime.now());

        assertThat(debtCalculator.calculateDebts(group), is(List.of(new Debt(new Friend("Paco"), new Friend("Sonia"), BigDecimal.valueOf(5).setScale(2)),
                new Debt(new Friend("Alba"), new Friend("Sonia"), BigDecimal.valueOf(5).setScale(2)))));
    }

    @Test
    public void shouldSettleDebtsWithDecimals(){
        group.addFriend("Sonia");
        group.addFriend("Paco");
        group.addFriend("Alba");
        group.addPayment("prueba", BigDecimal.valueOf(15.3), group.getFriendByName("Sonia"), LocalDateTime.now());
        group.addPayment("prueba", BigDecimal.valueOf(45.3), group.getFriendByName("Alba"), LocalDateTime.now());

        assertThat(debtCalculator.calculateDebts(group), is(List.of(new Debt(new Friend("Paco"), new Friend("Alba"), BigDecimal.valueOf(20.20).setScale(2)),
                new Debt(new Friend("Sonia"), new Friend("Alba"), BigDecimal.valueOf(4.90).setScale(2)))));

    }

    @Test
    public void shouldSettleNotRoundNumbers(){
        group.addFriend("Sonia");
        group.addFriend("Paco");
        group.addFriend("Alba");
        group.addPayment("prueba", BigDecimal.valueOf(10), group.getFriendByName("Sonia"), LocalDateTime.now());

        assertThat(debtCalculator.calculateDebts(group), is(List.of(new Debt(new Friend("Paco"), new Friend("Sonia"), BigDecimal.valueOf(3.34).setScale(2)),
                new Debt(new Friend("Alba"), new Friend("Sonia"), BigDecimal.valueOf(3.34).setScale(2)))));
    }

}

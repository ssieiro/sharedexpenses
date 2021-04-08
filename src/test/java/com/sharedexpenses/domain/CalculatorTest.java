package com.sharedexpenses.domain;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CalculatorTest {
    FriendsGroup group = new FriendsGroup("Grupo de test");

    @Test
    public void shouldCalculateBalanceWithoutPaymentsAndFriends() {
        List<Balance> result = Calculator.calculateBalance(group);
        assertThat(result, is(empty()));
    }

    @Test
    public void shouldCalculateBalanceWithoutPayments(){
        group.addFriend("Paco");
        List<Balance> result = Calculator.calculateBalance(group);
        assertThat(Calculator.calculateBalance(group), is(List.of(new Balance(BigDecimal.valueOf(0, 2), new Friend("Paco")))));
    }

    @Test
    public void shouldCalculateBalanceWithOnePaymentAndFriend(){
        group.addFriend("Sonia");
        group.addPayment("concepto test", BigDecimal.valueOf(20), "Sonia", LocalDateTime.now());

        assertThat(Calculator.calculateBalance(group).size(), is(1));
        assertThat(Calculator.calculateBalance(group), is(List.of(new Balance(BigDecimal.valueOf(0, 2), new Friend("Sonia")))));
    }

    @Test
    public void shouldCalculateBalanceWithTwoFriendsAndOnePayment(){
        group.addFriend("Sonia");
        group.addFriend("Paco");
        group.addPayment("concepto test", BigDecimal.valueOf(20), "Sonia", LocalDateTime.now());

        assertThat(Calculator.calculateBalance(group).size(), is(2));
        assertThat(Calculator.calculateBalance(group), is(List.of(new Balance(BigDecimal.valueOf(-10.00).setScale(2), new Friend("Sonia")),
                new Balance(BigDecimal.valueOf(10.00).setScale(2), new Friend("Paco")))));
    }

    @Test
    public void shouldCalculateBalanceWithTwoFriendsAndMoreThanOnePayment(){
        group.addFriend("Sonia");
        group.addFriend("Paco");
        group.addPayment("concepto test", BigDecimal.valueOf(20), "Sonia", LocalDateTime.now());
        group.addPayment("concepto test", BigDecimal.valueOf(20), "Sonia", LocalDateTime.now());
        group.addPayment("concepto test", BigDecimal.valueOf(20), "Paco", LocalDateTime.now());

        assertThat(Calculator.calculateBalance(group).size(), is(2));
        assertThat(Calculator.calculateBalance(group), is(List.of(new Balance(BigDecimal.valueOf(-10).setScale(2), new Friend("Sonia")),
                new Balance(BigDecimal.valueOf(10).setScale(2), new Friend("Paco")))));
    }

    @Test
    public void shouldCalculateBalanceWithDecimals(){
        group.addFriend("Sonia");
        group.addFriend("Paco");
        group.addPayment("concepto test", BigDecimal.valueOf(20.5), "Sonia", LocalDateTime.now());
        group.addPayment("concepto test", BigDecimal.valueOf(20), "Sonia", LocalDateTime.now());
        group.addPayment("concepto test", BigDecimal.valueOf(20), "Paco", LocalDateTime.now());

        assertThat(Calculator.calculateBalance(group).size(), is(2));
        assertThat(Calculator.calculateBalance(group), is(List.of(new Balance(BigDecimal.valueOf(-10.25), new Friend("Sonia")),
                new Balance(BigDecimal.valueOf(10.25), new Friend("Paco")))));
    }

    @Test
    public void shouldCompareTwoBalances(){
        Balance balance1 = new Balance(BigDecimal.valueOf(10), new Friend("Sonia"));
        Balance balance2 = new Balance(BigDecimal.valueOf(20), new Friend("Paco"));

        int resultado = balance1.compareTo(balance2);

        assertThat(resultado, is(-1));

    }

    @Test
    public void shouldSortBalanceList(){
        Balance balance20 = new Balance(BigDecimal.valueOf(20), new Friend("Sonia"));
        Balance balance10 = new Balance(BigDecimal.valueOf(10), new Friend("Sonia"));
        Balance balance30 = new Balance(BigDecimal.valueOf(30), new Friend("Paco"));

        List<Balance> list = new ArrayList<>();
        list.add(balance20);
        list.add(balance10);
        list.add(balance30);

        Collections.sort(list, Collections.reverseOrder());

        assertThat(list, contains(new Balance(BigDecimal.valueOf(30), new Friend("Paco")),
                new Balance(BigDecimal.valueOf(20), new Friend("Sonia")),
                new Balance(BigDecimal.valueOf(10), new Friend("Sonia"))));

    }

    @Test
    public void shouldSettleOneDebtAndTwoFriends(){
        group.addFriend("Sonia");
        group.addFriend("Paco");
        group.addPayment("prueba", BigDecimal.valueOf(20), "Sonia", LocalDateTime.now());
        List<Debt> debts = Calculator.calculateDebts(group);
        assertThat(debts, is(List.of(new Debt(new Friend("Paco"), new Friend("Sonia"), BigDecimal.valueOf(10).setScale(2)))));
    }

    @Test
    public void shouldSettleOneDebtWithThreeFriends(){
        group.addFriend("Sonia");
        group.addFriend("Paco");
        group.addFriend("Alba");
        group.addPayment("prueba", BigDecimal.valueOf(15), "Sonia", LocalDateTime.now());
        List<Debt> debts = Calculator.calculateDebts(group);

        assertThat(debts, is(List.of(new Debt(new Friend("Paco"), new Friend("Sonia"), BigDecimal.valueOf(5).setScale(2)),
                new Debt(new Friend("Alba"), new Friend("Sonia"), BigDecimal.valueOf(5).setScale(2)))));
    }

    @Test
    public void shouldSettleDebtsWithDecimals(){
        group.addFriend("Sonia");
        group.addFriend("Paco");
        group.addFriend("Alba");
        group.addPayment("prueba", BigDecimal.valueOf(15.3), "Sonia", LocalDateTime.now());
        group.addPayment("prueba", BigDecimal.valueOf(45.3), "Alba", LocalDateTime.now());
        List<Debt> debts = Calculator.calculateDebts(group);

        assertThat(debts, is(List.of(new Debt(new Friend("Paco"), new Friend("Alba"), BigDecimal.valueOf(20.20).setScale(2)),
                new Debt(new Friend("Sonia"), new Friend("Alba"), BigDecimal.valueOf(4.90).setScale(2)))));

    }

    @Test
    public void shouldSettleNotRoundNumbers(){
        group.addFriend("Sonia");
        group.addFriend("Paco");
        group.addFriend("Alba");
        group.addPayment("prueba", BigDecimal.valueOf(10), "Sonia", LocalDateTime.now());
        List<Debt> debts = Calculator.calculateDebts(group);

        assertThat(debts, is(List.of(new Debt(new Friend("Paco"), new Friend("Sonia"), BigDecimal.valueOf(3.34).setScale(2)),
                new Debt(new Friend("Alba"), new Friend("Sonia"), BigDecimal.valueOf(3.34).setScale(2)))));
    }

}

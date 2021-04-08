package com.sharedexpenses.domain;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
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

}

package com.sharedexpenses.domain;

import com.sharedexpenses.domain.datamodels.Balance;
import com.sharedexpenses.domain.datamodels.Friend;
import com.sharedexpenses.domain.datamodels.FriendsGroup;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class BalanceCalculatorTest {

    @Autowired
    private BalanceCalculator balanceCalculator;
    //BalanceCalculator balanceCalculator = BalanceCalculatorFactory.getInstance();
    FriendsGroup group = new FriendsGroup("Grupo de test");

    @Test
    public void shouldCalculateBalanceWithoutPaymentsAndFriends() {
        List<Balance> result = balanceCalculator.calculateBalance(group);
        assertThat(result, is(empty()));
    }

    @Test
    public void shouldCalculateBalanceWithoutPayments(){
        group.addFriend("Paco");
        List<Balance> result = balanceCalculator.calculateBalance(group);
        assertThat(balanceCalculator.calculateBalance(group), is(List.of(new Balance(BigDecimal.valueOf(0, 2), new Friend("Paco")))));
    }

    @Test
    public void shouldCalculateBalanceWithOnePaymentAndFriend(){
        group.addFriend("Sonia");
        group.addPayment("concepto test", BigDecimal.valueOf(20), "Sonia", LocalDateTime.now());

        assertThat(balanceCalculator.calculateBalance(group).size(), is(1));
        assertThat(balanceCalculator.calculateBalance(group), is(List.of(new Balance(BigDecimal.valueOf(0, 2), new Friend("Sonia")))));
    }

    @Test
    public void shouldCalculateBalanceWithTwoFriendsAndOnePayment(){
        group.addFriend("Sonia");
        group.addFriend("Paco");
        group.addPayment("concepto test", BigDecimal.valueOf(20), "Sonia", LocalDateTime.now());

        assertThat(balanceCalculator.calculateBalance(group).size(), is(2));
        assertThat(balanceCalculator.calculateBalance(group), is(List.of(new Balance(BigDecimal.valueOf(-10.00).setScale(2), new Friend("Sonia")),
                new Balance(BigDecimal.valueOf(10.00).setScale(2), new Friend("Paco")))));
    }

    @Test
    public void shouldCalculateBalanceWithTwoFriendsAndMoreThanOnePayment(){
        group.addFriend("Sonia");
        group.addFriend("Paco");
        group.addPayment("concepto test", BigDecimal.valueOf(20), "Sonia", LocalDateTime.now());
        group.addPayment("concepto test", BigDecimal.valueOf(20), "Sonia", LocalDateTime.now());
        group.addPayment("concepto test", BigDecimal.valueOf(20), "Paco", LocalDateTime.now());

        assertThat(balanceCalculator.calculateBalance(group).size(), is(2));
        assertThat(balanceCalculator.calculateBalance(group), is(List.of(new Balance(BigDecimal.valueOf(-10).setScale(2), new Friend("Sonia")),
                new Balance(BigDecimal.valueOf(10).setScale(2), new Friend("Paco")))));
    }

    @Test
    public void shouldCalculateBalanceWithDecimals(){
        group.addFriend("Sonia");
        group.addFriend("Paco");
        group.addPayment("concepto test", BigDecimal.valueOf(20.5), "Sonia", LocalDateTime.now());
        group.addPayment("concepto test", BigDecimal.valueOf(20), "Sonia", LocalDateTime.now());
        group.addPayment("concepto test", BigDecimal.valueOf(20), "Paco", LocalDateTime.now());

        assertThat(balanceCalculator.calculateBalance(group).size(), is(2));
        assertThat(balanceCalculator.calculateBalance(group), is(List.of(new Balance(BigDecimal.valueOf(-10.25), new Friend("Sonia")),
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
}

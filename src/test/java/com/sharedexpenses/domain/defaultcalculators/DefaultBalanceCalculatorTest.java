package com.sharedexpenses.domain.defaultcalculators;

import com.sharedexpenses.domain.BalanceCalculator;
import com.sharedexpenses.domain.datamodels.Balance;
import com.sharedexpenses.domain.datamodels.Friend;
import com.sharedexpenses.domain.datamodels.Payment;
import org.junit.jupiter.api.Test;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class DefaultBalanceCalculatorTest {

    private final BalanceCalculator balanceCalculator = new DefaultBalanceCalculator();
    Friend friendSonia = new Friend("Sonia", 1, 1);
    Friend friendPaco = new Friend("Paco", 1, 2);


    @Test
    public void shouldCalculateBalanceWithoutPaymentsAndFriends() {
        List<Balance> result = balanceCalculator.calculateBalance(Collections.emptyList(), Collections.emptyList());
        assertThat(result, is(empty()));
    }

    @Test
    public void shouldCalculateBalanceWithoutPayments(){
        List<Balance> result = balanceCalculator.calculateBalance(Collections.emptyList(), List.of(new Friend("Paco",1, 1)));
        assertThat(result, is(List.of(new Balance(BigDecimal.valueOf(0, 2), new Friend("Paco", 1, 1)))));
    }

    @Test
    public void shouldCalculateBalanceWithOnePaymentAndFriend(){
        Payment payment = new Payment("concepto test", BigDecimal.valueOf(20), 1, LocalDateTime.now());
        List<Balance> result = balanceCalculator.calculateBalance(List.of(payment), List.of(friendSonia));
        assertThat(result, is(List.of(new Balance(BigDecimal.valueOf(0, 2), new Friend("Sonia",1, 1)))));
    }

    @Test
    public void shouldCalculateBalanceWithTwoFriendsAndOnePayment(){
        Payment payment = new Payment("concepto test", BigDecimal.valueOf(20), 1, LocalDateTime.now());
        List<Balance> result = balanceCalculator.calculateBalance(List.of(payment), List.of(friendSonia, friendPaco));

        assertThat(result, is(List.of(new Balance(BigDecimal.valueOf(-10.00).setScale(2), new Friend("Sonia", 1, 1)),
                new Balance(BigDecimal.valueOf(10.00).setScale(2), new Friend("Paco", 1, 2)))));
    }

    @Test
    public void shouldCalculateBalanceWithTwoFriendsAndMoreThanOnePayment(){
        Payment payment1 = new Payment("concepto test", BigDecimal.valueOf(20), 1, LocalDateTime.now());
        Payment payment2 = new Payment("concepto test", BigDecimal.valueOf(20), 1, LocalDateTime.now());
        Payment payment3 = new Payment("concepto test", BigDecimal.valueOf(20), 2, LocalDateTime.now());
        List<Balance> result = balanceCalculator.calculateBalance(List.of(payment1, payment2, payment3), List.of(friendSonia, friendPaco));

        assertThat(result, is(List.of(new Balance(BigDecimal.valueOf(-10).setScale(2), new Friend("Sonia",1,  1)),
                new Balance(BigDecimal.valueOf(10).setScale(2), new Friend("Paco", 1, 2)))));
    }

    @Test
    public void shouldCalculateBalanceWithDecimals(){
        Payment payment1 = new Payment("concepto test", BigDecimal.valueOf(20.5), 1, LocalDateTime.now());
        Payment payment2 = new Payment("concepto test", BigDecimal.valueOf(20), 1, LocalDateTime.now());
        Payment payment3 = new Payment("concepto test", BigDecimal.valueOf(20), 2, LocalDateTime.now());
        List<Balance> result = balanceCalculator.calculateBalance(List.of(payment1, payment2, payment3), List.of(friendSonia, friendPaco));

        assertThat(result, is(List.of(new Balance(BigDecimal.valueOf(-10.25), new Friend("Sonia", 1, 1)),
                new Balance(BigDecimal.valueOf(10.25), new Friend("Paco",1, 2)))));
    }

    @Test
    public void shouldCompareTwoBalances(){
        Balance balance1 = new Balance(BigDecimal.valueOf(10), new Friend("Sonia",1, 1));
        Balance balance2 = new Balance(BigDecimal.valueOf(20), new Friend("Paco", 1, 2));

        int resultado = balance1.compareTo(balance2);

        assertThat(resultado, is(-1));
    }

    @Test
    public void shouldSortBalanceList(){
        Balance balance20 = new Balance(BigDecimal.valueOf(20), new Friend("Sonia",1,  1));
        Balance balance10 = new Balance(BigDecimal.valueOf(10), new Friend("Sonia",1,  2));
        Balance balance30 = new Balance(BigDecimal.valueOf(30), new Friend("Paco",1,  2));

        List<Balance> list = new ArrayList<>();
        list.add(balance20);
        list.add(balance10);
        list.add(balance30);

        Collections.sort(list, Collections.reverseOrder());

        assertThat(list, contains(new Balance(BigDecimal.valueOf(30), new Friend("Paco",1, 2)),
                new Balance(BigDecimal.valueOf(20), new Friend("Sonia",1, 1)),
                new Balance(BigDecimal.valueOf(10), new Friend("Sonia",1, 1))));

    }
}

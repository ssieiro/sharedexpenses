package sharedexpenses.domain;

import sharedexpenses.domain.*;
import sharedexpenses.domain.defaultcalculators.DefaultBalanceCalculator;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DefaultBalanceCalculatorTest {

    private final BalanceCalculator balanceCalculator = new DefaultBalanceCalculator();
    Friend friendSonia = new Friend(1, "Sonia", new FriendsGroup("test grupo"));
    Friend friendPaco = new Friend(2, "Paco", new FriendsGroup("test grupo"));



    @Test
    public void shouldCalculateBalanceWithoutPaymentsAndFriends() {
        List<Balance> result = balanceCalculator.calculateBalance(Collections.emptyList(), Collections.emptyList());
        MatcherAssert.assertThat(result, Matchers.is(Matchers.empty()));
    }

    @Test
    public void shouldCalculateBalanceWithoutPayments(){
        List<Balance> result = balanceCalculator.calculateBalance(Collections.emptyList(), List.of(friendPaco));
        MatcherAssert.assertThat(result, Matchers.is(List.of(new Balance(BigDecimal.valueOf(0, 2), friendPaco))));
    }

    @Test
    public void shouldCalculateBalanceWithOnePaymentAndFriend(){
        Payment payment = new Payment(1, "concepto test", BigDecimal.valueOf(20), friendSonia, LocalDateTime.now());
        List<Balance> result = balanceCalculator.calculateBalance(List.of(payment), List.of(friendSonia));
        MatcherAssert.assertThat(result, Matchers.is(List.of(new Balance(BigDecimal.valueOf(0, 2), friendSonia))));
    }

    @Test
    public void shouldCalculateBalanceWithTwoFriendsAndOnePayment(){
        Payment payment = new Payment(1, "concepto test", BigDecimal.valueOf(20), friendSonia, LocalDateTime.now());
        List<Balance> result = balanceCalculator.calculateBalance(List.of(payment), List.of(friendSonia, friendPaco));

        MatcherAssert.assertThat(result, Matchers.is(List.of(new Balance(BigDecimal.valueOf(-10.00).setScale(2), friendSonia),
                new Balance(BigDecimal.valueOf(10.00).setScale(2), friendPaco))));
    }

    @Test
    public void shouldCalculateBalanceWithTwoFriendsAndMoreThanOnePayment(){
        Payment payment1 = new Payment(1, "concepto test", BigDecimal.valueOf(20), friendSonia, LocalDateTime.now());
        Payment payment2 = new Payment(2, "concepto test", BigDecimal.valueOf(20), friendSonia, LocalDateTime.now());
        Payment payment3 = new Payment(3, "concepto test", BigDecimal.valueOf(20), friendPaco, LocalDateTime.now());
        List<Balance> result = balanceCalculator.calculateBalance(List.of(payment1, payment2, payment3), List.of(friendSonia, friendPaco));

        MatcherAssert.assertThat(result, Matchers.is(List.of(new Balance(BigDecimal.valueOf(-10).setScale(2), friendSonia),
                new Balance(BigDecimal.valueOf(10).setScale(2), friendPaco))));
    }

    @Test
    public void shouldCalculateBalanceWithDecimals(){
        Payment payment1 = new Payment(1, "concepto test", BigDecimal.valueOf(20.5), friendSonia, LocalDateTime.now());
        Payment payment2 = new Payment(2, "concepto test", BigDecimal.valueOf(20), friendSonia, LocalDateTime.now());
        Payment payment3 = new Payment(3, "concepto test", BigDecimal.valueOf(20), friendPaco, LocalDateTime.now());
        List<Balance> result = balanceCalculator.calculateBalance(List.of(payment1, payment2, payment3), List.of(friendSonia, friendPaco));

        MatcherAssert.assertThat(result, Matchers.is(List.of(new Balance(BigDecimal.valueOf(-10.25), friendSonia),
                new Balance(BigDecimal.valueOf(10.25), friendPaco))));
    }

    @Test
    public void shouldCompareTwoBalances(){
        Balance balance1 = new Balance(BigDecimal.valueOf(10), friendSonia);
        Balance balance2 = new Balance(BigDecimal.valueOf(20), friendPaco);

        int resultado = balance1.compareTo(balance2);

        MatcherAssert.assertThat(resultado, Matchers.is(-1));
    }

    @Test
    public void shouldSortBalanceList(){
        Balance balance20 = new Balance(BigDecimal.valueOf(20), friendSonia);
        Balance balance10 = new Balance(BigDecimal.valueOf(10), friendSonia);
        Balance balance30 = new Balance(BigDecimal.valueOf(30), friendPaco);

        List<Balance> list = new ArrayList<>();
        list.add(balance20);
        list.add(balance10);
        list.add(balance30);

        Collections.sort(list, Collections.reverseOrder());

        MatcherAssert.assertThat(list, Matchers.contains(new Balance(BigDecimal.valueOf(30), friendPaco),
                new Balance(BigDecimal.valueOf(20), friendSonia),
                new Balance(BigDecimal.valueOf(10), friendSonia)));
    }
}

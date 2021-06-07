package sharedexpenses.domain;

import sharedexpenses.domain.defaultcalculators.DefaultBalanceCalculator;
import sharedexpenses.domain.defaultcalculators.DefaultDebtCalculator;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;



public class DefaultDebtCalculatorTest {

    BalanceCalculator balanceCalculator = new DefaultBalanceCalculator();
    DebtCalculator debtCalculator = new DefaultDebtCalculator(balanceCalculator);
    FriendsGroup testGrupo = new FriendsGroup("Test grupo");
    Friend friendSonia = new Friend(1, "Sonia", testGrupo);
    Friend friendPaco = new Friend(2, "Paco", testGrupo);
    Friend friendAlba = new Friend(3, "Alba", testGrupo);

    @Test
    public void shouldSettleOneDebtAndTwoFriends(){
        Payment payment = new Payment(1, "concepto test", BigDecimal.valueOf(20), friendSonia, LocalDateTime.now());
        List<Debt> debts = debtCalculator.calculateDebts(List.of(payment), List.of(friendSonia, friendPaco));
        MatcherAssert.assertThat(debts, Matchers.is(List.of(new Debt(friendPaco, friendSonia, BigDecimal.valueOf(10).setScale(2)))));
    }

    @Test
    public void shouldSettleOneDebtWithThreeFriends(){
        Payment payment = new Payment(1, "concepto test", BigDecimal.valueOf(15), friendSonia, LocalDateTime.now());
        List<Debt> debts = debtCalculator.calculateDebts(List.of(payment), List.of(friendSonia, friendPaco, friendAlba));

        MatcherAssert.assertThat(debts, Matchers.is(List.of(new Debt(friendPaco, friendSonia, BigDecimal.valueOf(5).setScale(2)),
                new Debt(friendAlba, friendSonia, BigDecimal.valueOf(5).setScale(2)))));
    }

    @Test
    public void shouldSettleDebtsWithDecimals(){
        Payment payment = new Payment(1, "concepto test", BigDecimal.valueOf(15.3), friendSonia, LocalDateTime.now());
        Payment payment2 = new Payment(2,"concepto test", BigDecimal.valueOf(45.3), friendAlba, LocalDateTime.now());

        List<Debt> debts = debtCalculator.calculateDebts(List.of(payment, payment2), List.of(friendSonia, friendPaco, friendAlba));

        MatcherAssert.assertThat(debts, Matchers.is(List.of(new Debt(friendPaco, friendAlba, BigDecimal.valueOf(20.20).setScale(2)),
                new Debt(friendSonia, friendAlba, BigDecimal.valueOf(4.90).setScale(2)))));

    }

    @Test
    public void shouldSettleNotRoundNumbers(){
        Payment payment = new Payment(1, "concepto test", BigDecimal.valueOf(10), friendSonia, LocalDateTime.now());

        List<Debt> debts = debtCalculator.calculateDebts(List.of(payment), List.of(friendSonia, friendPaco, friendAlba));
        MatcherAssert.assertThat(debts, Matchers.is(List.of(new Debt(friendPaco, friendSonia, BigDecimal.valueOf(3.34).setScale(2)),
                new Debt(friendAlba, friendSonia, BigDecimal.valueOf(3.34).setScale(2)))));
    }

}

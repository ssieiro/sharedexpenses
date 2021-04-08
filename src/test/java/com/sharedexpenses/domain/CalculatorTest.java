package com.sharedexpenses.domain;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

public class DebtsCalculatorTest {
    FriendsGroup group = new FriendsGroup("Grupo de test");

    @Test
    public void shouldCalculateBalanceWithoutPayments() {
        List<Debt> result = DebtsCalculator.calculateDebts(group);
        assertThat(result, is(empty()));
    }
}

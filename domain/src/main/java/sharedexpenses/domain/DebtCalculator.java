package sharedexpenses.domain;

import java.util.List;

public interface DebtCalculator {
    List<Debt> calculateDebts(List<Payment> payments, List<Friend> friends);
}

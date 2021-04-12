package com.sharedexpenses.restservice;

import com.sharedexpenses.domain.datamodels.Balance;
import com.sharedexpenses.domain.datamodels.Debt;
import com.sharedexpenses.domain.datamodels.FriendsGroup;
import java.util.List;
import java.util.Optional;

public interface SharedExpensesService {
    public List<FriendsGroup> getAllGroups();
    public Optional<FriendsGroup> findGroupByName(String groupName);
    public List<Balance> calculateBalance(String groupName);
    public List<Debt> calculateDebts(String groupName);
}


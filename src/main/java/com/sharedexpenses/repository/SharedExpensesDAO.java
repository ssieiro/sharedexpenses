package com.sharedexpenses.repository;

import com.sharedexpenses.domain.datamodels.Balance;
import com.sharedexpenses.domain.datamodels.Debt;
import com.sharedexpenses.domain.datamodels.FriendsGroup;

import java.util.List;
import java.util.Optional;

public interface SharedExpensesDAO {

    public List<FriendsGroup> getAllGroups();
    public Optional<FriendsGroup> getGroupByName(String groupName);
    public List<Balance> calculateBalance(String groupName);
    public List<Debt> calculateDebts(String groupName);
}

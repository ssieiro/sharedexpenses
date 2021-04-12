package com.sharedexpenses.repository.fakeimpl;

import com.sharedexpenses.domain.datamodels.Balance;
import com.sharedexpenses.domain.datamodels.Debt;
import com.sharedexpenses.domain.datamodels.FriendsGroup;
import com.sharedexpenses.repository.SharedExpensesDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class FakeDAOImpl implements SharedExpensesDAO {

    @Autowired
    FakeRepository fakeRepository;

    @Override
    public List<FriendsGroup> getAllGroups() {
        return fakeRepository.getFriendsGroups();
    }

    @Override
    public Optional<FriendsGroup> getGroupByName(String groupName) {
        return fakeRepository.getGroupByName(groupName);
    }

    @Override
    public List<Balance> calculateBalance(String groupName) {
        return fakeRepository.calculateBalance(groupName);
    }

    @Override
    public List<Debt> calculateDebts(String groupName) {
        return fakeRepository.calculateDebts(groupName);
    }
}

package com.sharedexpenses.restservice;

import com.sharedexpenses.domain.datamodels.Balance;
import com.sharedexpenses.domain.datamodels.Debt;
import com.sharedexpenses.domain.datamodels.FriendsGroup;
import com.sharedexpenses.repository.SharedExpensesDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SharedExpensesServiceImpl implements SharedExpensesService {
    @Autowired
    private SharedExpensesDAO sharedExpensesDAO;

    @Override
    public List<FriendsGroup> getAllGroups() {
        return sharedExpensesDAO.getAllGroups();
    }

    @Override
    public Optional<FriendsGroup> findGroupByName(String groupName) {
        return sharedExpensesDAO.getGroupByName(groupName);
    }

    @Override
    public List<Balance> calculateBalance(String groupName) {
        return sharedExpensesDAO.calculateBalance(groupName);
    }

    @Override
    public List<Debt> calculateDebts(String groupName) {
        return sharedExpensesDAO.calculateDebts(groupName);
    }
}


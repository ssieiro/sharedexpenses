package com.sharedexpenses.restservice;

import com.sharedexpenses.domain.datamodels.FriendsGroup;
import com.sharedexpenses.repository.SharedExpensesDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SharedExpensesServiceImpl implements SharedExpensesService {
    @Autowired
    private SharedExpensesDAO sharedExpensesDAO;

    @Override
    public List<FriendsGroup> getAllGroups() {
        return sharedExpensesDAO.getAllGroups();
    }
}


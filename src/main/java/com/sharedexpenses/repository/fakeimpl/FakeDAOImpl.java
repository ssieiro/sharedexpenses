package com.sharedexpenses.repository.fakeimpl;

import com.sharedexpenses.domain.datamodels.FriendsGroup;
import com.sharedexpenses.repository.SharedExpensesDAO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FakeDAOImpl implements SharedExpensesDAO {

    @Override
    public List<FriendsGroup> getAllGroups() {
        FakeRepository fakeRepository = new FakeRepository();
        return fakeRepository.getFriendsGroups();
    }
}

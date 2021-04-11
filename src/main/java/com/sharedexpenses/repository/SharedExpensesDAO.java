package com.sharedexpenses.repository;

import com.sharedexpenses.domain.datamodels.FriendsGroup;

import java.util.List;

public interface SharedExpensesDAO {

    public List<FriendsGroup> getAllGroups();
}

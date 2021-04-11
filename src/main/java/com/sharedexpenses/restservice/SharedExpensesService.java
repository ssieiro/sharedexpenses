package com.sharedexpenses.restservice;

import com.sharedexpenses.domain.datamodels.FriendsGroup;
import java.util.List;

public interface SharedExpensesService {
    public List<FriendsGroup> getAllGroups();
}


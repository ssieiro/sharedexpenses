package com.sharedexpenses.restservice;

import com.sharedexpenses.domain.datamodels.*;
import com.sharedexpenses.repository.SharedExpensesDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class SharedExpensesServiceImpl implements SharedExpensesService {

    private final SharedExpensesDAO sharedExpensesDAO;

    @Autowired
    public SharedExpensesServiceImpl(SharedExpensesDAO sharedExpensesDAO){
        this.sharedExpensesDAO = sharedExpensesDAO;
    }

    @Override
    public List<FriendsGroup> getAllGroups() {
        return sharedExpensesDAO.getAllGroups();
    }

    @Override
    public Optional<FriendsGroup> findGroupByName(String groupName) { return sharedExpensesDAO.getGroupByName(groupName); }

    @Override
    public List<Friend> getFriends(FriendsGroup group) { return sharedExpensesDAO.getFriends(group);}

    @Override
    public List<Payment> getPayments(FriendsGroup group) { return sharedExpensesDAO.getPayments(group);}

    @Override
    public List<Balance> calculateBalance(FriendsGroup friendsGroup) { return sharedExpensesDAO.calculateBalance(friendsGroup); }

    @Override
    public List<Debt> calculateDebts(FriendsGroup friendsGroup) { return sharedExpensesDAO.calculateDebts(friendsGroup); }

    @Override
    public FriendsGroup addGroup(FriendsGroup group) { return sharedExpensesDAO.addGroup(group);}

    @Override
    public Friend addFriend(FriendsGroup group, Friend friend) {return sharedExpensesDAO.addFriend(group, friend);}

    @Override
    public Payment addPayment(FriendsGroup group, Payment payment){ return sharedExpensesDAO.addPayment(group, payment); }
}


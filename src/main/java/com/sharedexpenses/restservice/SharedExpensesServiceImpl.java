package com.sharedexpenses.restservice;

import com.sharedexpenses.domain.datamodels.*;
import com.sharedexpenses.repository.SharedExpensesDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SharedExpensesServiceImpl implements SharedExpensesService {

    private final SharedExpensesDAO sharedExpensesDAO;

    @Autowired
    public SharedExpensesServiceImpl(SharedExpensesDAO sharedExpensesDAO){ this.sharedExpensesDAO = sharedExpensesDAO; }


    // GET ALL
    @Override
    public List<FriendsGroup> getAllGroups() { return sharedExpensesDAO.getAllGroups(); }

    @Override
    public List<Friend> getAllFriends() { return sharedExpensesDAO.getAllFriends(); }

    @Override
    public List<Payment> getAllPayments() { return sharedExpensesDAO.getAllPayments(); }

    //GET BY ID
    @Override
    public FriendsGroup getGroupById(int id) {return sharedExpensesDAO.getGroupById(id);}

    @Override
    public List<Friend> getFriendsByGroup(int groupId) { return sharedExpensesDAO.getFriendsByGroup(groupId);}

    @Override
    public List<Payment> getPaymentsByGroup(int groupId) { return sharedExpensesDAO.getPaymentsByGroup(groupId);}

    //CALCULATE
    @Override
    public List<Balance> calculateBalance(int groupId) { return sharedExpensesDAO.calculateBalance(groupId); }

    @Override
    public List<Debt> calculateDebts(int groupId) { return sharedExpensesDAO.calculateDebts(groupId); }

    //ADD
    @Override
    public FriendsGroup addGroup(FriendsGroup group) { return sharedExpensesDAO.addGroup(group);}

    @Override
    public Friend addFriend(Friend friend) {return sharedExpensesDAO.addFriend(friend);}

    @Override
    public Payment addPayment(Payment payment){ return sharedExpensesDAO.addPayment(payment); }
}


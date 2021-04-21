package com.sharedexpenses.repository.mysqlImp;

import com.sharedexpenses.domain.datamodels.*;
import com.sharedexpenses.repository.SharedExpensesDAO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.stereotype.Component;


import java.util.Optional;

@Component
public class MysqlDAOImpl implements SharedExpensesDAO {

    private final EntityManager entityManager;

    @Autowired
    public MysqlDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }


    @Override
    public List<FriendsGroup> getAllGroups() {
        return null;
    }

    @Override
    public Optional<FriendsGroup> getGroupByName(String groupName) {
        return Optional.empty();
    }

    @Override
    public List<Friend> getFriends(FriendsGroup group) {
        return null;
    }

    @Override
    public List<Payment> getPayments(FriendsGroup group) {
        return null;
    }

    @Override
    public List<Balance> calculateBalance(FriendsGroup friendsGroup) {
        return null;
    }

    @Override
    public List<Debt> calculateDebts(FriendsGroup friendsGroup) {
        return null;
    }

    @Override
    public FriendsGroup addGroup(FriendsGroup group) {
        return null;
    }

    @Override
    public Friend addFriend(FriendsGroup group, Friend friend) {
        return null;
    }

    @Override
    public Payment addPayment(FriendsGroup group, Payment payment) {
        return null;
    }
}

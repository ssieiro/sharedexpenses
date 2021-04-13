package com.sharedexpenses.repository.fakeimpl;

import com.sharedexpenses.domain.datamodels.*;
import com.sharedexpenses.repository.SharedExpensesDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
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
    public List<Friend> getFriends(FriendsGroup group) { return fakeRepository.getFriends(group);}

    @Override
    public List<Payment> getPayments(FriendsGroup group) { return fakeRepository.getPayments(group);}

    @Override
    public List<Balance> calculateBalance(FriendsGroup friendsGroup){ return fakeRepository.calculateBalance(friendsGroup); }

    @Override
    public List<Debt> calculateDebts(FriendsGroup friendsGroup){
        return fakeRepository.calculateDebts(friendsGroup);
    }

    @Override
    public FriendsGroup addGroup(FriendsGroup group) { return fakeRepository.addGroup(group); }

    @Override
    public Friend addFriend(FriendsGroup group, Friend friend){ return fakeRepository.addFriend(group, friend); }

    @Override
    public Payment addPayment(FriendsGroup group, Payment payment) { return fakeRepository.addPayment(group, payment); }

}

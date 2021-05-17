package com.sharedexpenses.repository.mysqlImp;

import com.sharedexpenses.domain.BalanceCalculator;
import com.sharedexpenses.domain.DebtCalculator;
import com.sharedexpenses.domain.datamodels.*;
import com.sharedexpenses.repository.SharedExpensesDAO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class MysqlDAOImpl implements SharedExpensesDAO {

    private final BalanceCalculator balanceCalculator;
    private final DebtCalculator debtCalculator;

    private final FriendsGroupMybatisRepository friendsGroupRepository;

    @Autowired
    public MysqlDAOImpl(FriendsGroupMybatisRepository friendsGroupRepository, BalanceCalculator balanceCalculator, DebtCalculator debtCalculator){
        this.friendsGroupRepository = friendsGroupRepository;
        this.balanceCalculator = balanceCalculator;
        this.debtCalculator = debtCalculator;
    }

    //GET ALL
    @Override
    public List<FriendsGroup> getAllGroups() { return friendsGroupRepository.findAllGroups(); }

    @Override
    public List<Friend> getAllFriends() { return friendsGroupRepository.findAllFriends(); }

    @Override
    public List<Payment> getAllPayments() { return friendsGroupRepository.findAllPayments(); }

    //GET BY ID
    @Override
    public FriendsGroup getGroupById(long id) { return friendsGroupRepository.findGroupById(id); }

    @Override
    public List<Friend> getFriendsByGroup(long groupId) { return friendsGroupRepository.findFriendsByGroup(groupId); }

    @Override
    public List<Payment> getPaymentsByGroup(long groupId) {
        List<Friend> friends = getFriendsByGroup(groupId);
        List<Payment> payments = new ArrayList<>();
        friends.forEach(friend -> {
            List<Payment> friendPayments = friendsGroupRepository.findPaymentsByFriend(friend.getId());
            payments.addAll(friendPayments);
        });
        return payments;}


    //CALCULATE
    @Override
    public List<Balance> calculateBalance(long groupId) {
        return balanceCalculator.calculateBalance(getPaymentsByGroup(groupId), getFriendsByGroup(groupId));
    }

    @Override
    public List<Debt> calculateDebts(long groupId) {
        return debtCalculator.calculateDebts(getPaymentsByGroup(groupId), getFriendsByGroup(groupId));
    }


    //ADD
    @Override
    public FriendsGroup addGroup(FriendsGroup group) {
        friendsGroupRepository.insertFriendsGroup(group);
        return friendsGroupRepository.findGroupById(group.getId());
    }

    @Override
    public Friend addFriend(Friend friend) {
        friendsGroupRepository.insertFriend(friend);
        return friendsGroupRepository.findFriendById(friend.getId());
    }

    @Override
    public Payment addPayment(Payment payment) {
        friendsGroupRepository.insertPayment(payment);
        return friendsGroupRepository.findPaymentById(payment.getId());
    }

    @Override
    public void deleteGroup(long id) { friendsGroupRepository.deleteGroupById(id); }

    @Override
    public void deleteFriend(long id) { friendsGroupRepository.deleteFriendById(id);}

    @Override
    public void deletePayment(long id) { friendsGroupRepository.deletePaymentById(id);}
}

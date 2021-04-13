package com.sharedexpenses.repository.fakeimpl;

import com.sharedexpenses.domain.BalanceCalculator;
import com.sharedexpenses.domain.DebtCalculator;
import com.sharedexpenses.domain.datamodels.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class FakeRepository {
    private final List<FriendsGroup> groupList = new ArrayList<>();

    @Autowired
    BalanceCalculator balanceCalculator;

    @Autowired
    DebtCalculator debtCalculator;

    public FakeRepository(){
        FriendsGroup grupo1 = new FriendsGroup("Grupo1");
        FriendsGroup grupo2 = new FriendsGroup("Grupo2");

        grupo1.addFriend("Sonia");
        grupo1.addFriend("Paco");
        grupo2.addFriend("Alba");
        grupo2.addFriend("Isabel");

        grupo1.addPayment("Pago fake 1", BigDecimal.valueOf(20), grupo1.getFriendByName("Sonia"), LocalDateTime.now());
        grupo2.addPayment("Pago fake 1", BigDecimal.valueOf(10), grupo2.getFriendByName("Alba"), LocalDateTime.now());
        grupo2.addPayment("Pago fake 2", BigDecimal.valueOf(30), grupo2.getFriendByName("Isabel"), LocalDateTime.now());

        this.groupList.add(grupo1);
        this.groupList.add(grupo2);
    }

    public List<FriendsGroup> getFriendsGroups() {
        return groupList;
    }

    public Optional<FriendsGroup> getGroupByName(String groupName){
        return groupList.stream().filter(group -> group.getName().equals(groupName)).findFirst();
    }

    public List<Friend> getFriends(FriendsGroup group) {return group.getFriendsList();}
    public List<Payment> getPayments(FriendsGroup group) {return group.getPayments();}

    public List<Balance> calculateBalance(FriendsGroup friendsGroup){return balanceCalculator.calculateBalance(friendsGroup);}

    public List<Debt> calculateDebts(FriendsGroup friendsGroup){ return debtCalculator.calculateDebts(friendsGroup);}

    public FriendsGroup addGroup(FriendsGroup group){
        groupList.add(group);
        return group;
    }

    public Friend addFriend(FriendsGroup group, Friend friend) {
        groupList.remove(group);
        group.addFriend(friend.getName());
        groupList.add(group);
        return friend;
    }

    public Payment addPayment (FriendsGroup group, Payment payment){
        groupList.remove(group);
        group.addPayment(payment.getConcept(), payment.getAmount(), payment.getPayer(), payment.getDate());
        groupList.add(group);
        return payment;
    }

}

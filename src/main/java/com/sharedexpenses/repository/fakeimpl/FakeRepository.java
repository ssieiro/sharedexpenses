package com.sharedexpenses.repository.fakeimpl;

import com.sharedexpenses.domain.BalanceCalculator;
import com.sharedexpenses.domain.DebtCalculator;
import com.sharedexpenses.domain.datamodels.Balance;
import com.sharedexpenses.domain.datamodels.Debt;
import com.sharedexpenses.domain.datamodels.FriendsGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
public class FakeRepository {
    private final List<FriendsGroup> friendsGroups = new ArrayList<>();

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

        grupo1.addPayment("Pago fake 1", BigDecimal.valueOf(20), "Sonia", LocalDateTime.now());


        grupo2.addPayment("Pago fake 1", BigDecimal.valueOf(10), "Alba", LocalDateTime.now());
        grupo2.addPayment("Pago fake 2", BigDecimal.valueOf(30), "Isabel", LocalDateTime.now());


        this.friendsGroups.add(grupo1);
        this.friendsGroups.add(grupo2);
    }

    public List<FriendsGroup> getFriendsGroups() {
        return friendsGroups;
    }

    public Optional<FriendsGroup> getGroupByName(String groupName){

        return friendsGroups.stream().filter(group -> group.getName().equals(groupName)).findFirst();

    }

    public List<Balance> calculateBalance(String groupName){
        Optional<FriendsGroup> opFriendsGroup = getGroupByName(groupName);

        if (opFriendsGroup.isPresent()){
            FriendsGroup friendsGroup = opFriendsGroup.get();
            return balanceCalculator.calculateBalance(friendsGroup);

        }
        else {return Collections.emptyList();}
    }

    public List<Debt> calculateDebts(String groupName){
        Optional<FriendsGroup> opFriendsGroup = getGroupByName(groupName);

        if (opFriendsGroup.isPresent()){
            FriendsGroup friendsGroup = opFriendsGroup.get();
            return debtCalculator.calculateDebts(friendsGroup);

        }
        else {return Collections.emptyList();}
    }

}

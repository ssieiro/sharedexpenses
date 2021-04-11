package com.sharedexpenses.repository.fakeimpl;

import com.sharedexpenses.domain.datamodels.FriendsGroup;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FakeRepository {
    private final List<FriendsGroup> friendsGroups = new ArrayList<>();

    public FakeRepository(){
        FriendsGroup grupo1 = new FriendsGroup("Mi grupo 1");
        FriendsGroup grupo2 = new FriendsGroup("Mi grupo 2");

        grupo1.addFriend("Sonia");
        grupo1.addFriend("Paco");

        grupo2.addFriend("Alba");
        grupo2.addFriend("Isabel");

        grupo1.addPayment("Pago fake 1", BigDecimal.valueOf(20), "Sonia", LocalDateTime.now());


        grupo2.addPayment("Pago fake 1", BigDecimal.valueOf(10), "Alba", LocalDateTime.now());
        grupo2.addPayment("Pago fake 1", BigDecimal.valueOf(30), "Isabel", LocalDateTime.now());


        this.friendsGroups.add(grupo1);
        this.friendsGroups.add(grupo2);
    }

    public List<FriendsGroup> getFriendsGroups() {
        return friendsGroups;
    }
}

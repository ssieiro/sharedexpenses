package com.sharedexpenses.domain;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import com.sharedexpenses.domain.datamodels.Friend;
import com.sharedexpenses.domain.datamodels.FriendsGroup;
import com.sharedexpenses.domain.datamodels.Payment;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;


public class FriendsGroupTest {
    FriendsGroup group = new FriendsGroup("Grupo de test");

    @Test
    public void shouldGetGroupName(){
        assertThat(group.getName(), is("Grupo de test"));
    }

    @Test
    public void canAddFriend() {
        group.addFriend("Paco");
        assertThat(group.getFriendsList(), contains(new Friend("Paco")));
    }

    @Test
    public void canAddPayment() {
        LocalDateTime date = LocalDateTime.now();
        group.addFriend("Paco");
        group.addPayment("concepto test", BigDecimal.valueOf(10), group.getFriendByName("Paco"), date);

        assertThat(group.getPayments(), contains(new Payment("concepto test", BigDecimal.valueOf(10), new Friend("Paco"), date)));
    }



}

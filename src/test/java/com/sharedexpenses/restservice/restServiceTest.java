package com.sharedexpenses.restservice;

import com.sharedexpenses.domain.datamodels.Debt;
import com.sharedexpenses.domain.datamodels.FriendsGroup;
import com.sharedexpenses.repository.fakeimpl.FakeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@SpringBootTest
public class restServiceTest {

    @Autowired
    FakeRepository fakeRepository;

    @Test
    public void shouldCalculateDebts() {

        List<Debt> debts = fakeRepository.calculateDebts("Grupo1");
        assertThat(debts, is(notNullValue()));

    }

    @Test
    public void shouldFilterFriends() {
        Optional<FriendsGroup> friendsGroup = fakeRepository.getGroupByName("Grupo1");
        assertThat(friendsGroup, is(notNullValue()));
    }
}

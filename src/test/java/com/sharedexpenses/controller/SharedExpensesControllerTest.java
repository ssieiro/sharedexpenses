package com.sharedexpenses.controller;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import com.sharedexpenses.domain.datamodels.FriendsGroup;
import com.sharedexpenses.restservice.SharedExpensesService;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class SharedExpensesControllerTest {
    private final SharedExpensesService sharedExpensesService = mock(SharedExpensesService.class);
    private final SharedExpensesController sharedExpensesController = new SharedExpensesController(sharedExpensesService);

    @Test
    public void shouldGetGroup(){
        FriendsGroup expectedGroup = new FriendsGroup("Grupo1");
        when(sharedExpensesService.findGroupByName("Grupo1")).thenReturn(Optional.of(expectedGroup));
        FriendsGroup group = sharedExpensesController.getGroup(expectedGroup.getName());
        assertThat(group, is(expectedGroup));
    }

}
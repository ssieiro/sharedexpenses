package com.sharedexpenses.domain;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.Test;


public class FriendsGroupTest {
    FriendsGroup group = new FriendsGroup(1,"Grupo de test");

    @Test
    public void shouldGetGroupName(){
        assertThat(group.getName(), is("Grupo de test"));
    }
}

package com.sharedexpenses.domain;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import com.sharedexpenses.domain.datamodels.FriendsGroup;
import org.junit.jupiter.api.Test;


public class FriendsGroupTest {
    FriendsGroup group = new FriendsGroup("Grupo de test", 1);

    @Test
    public void shouldGetGroupName(){
        assertThat(group.getName(), is("Grupo de test"));
    }
}

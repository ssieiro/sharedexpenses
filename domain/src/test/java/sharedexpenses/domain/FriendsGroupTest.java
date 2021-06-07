package sharedexpenses.domain;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

public class FriendsGroupTest {
    FriendsGroup group = new FriendsGroup(1,"Grupo de test");

    @Test
    public void shouldGetGroupName(){
        MatcherAssert.assertThat(group.getName(), Matchers.is("Grupo de test"));
    }
}

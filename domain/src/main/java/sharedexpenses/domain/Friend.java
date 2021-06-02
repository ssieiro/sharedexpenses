package sharedexpenses.domain;

import java.util.Objects;

public class Friend {
    private long id;
    private String name;
    private FriendsGroup friendsGroup;

    public Friend(){}

    public Friend(long id, String name, FriendsGroup friendsGroup) {
        this.name = name;
        this.friendsGroup = friendsGroup;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FriendsGroup getFriendsGroup() {
        return friendsGroup;
    }

    public void setFriendsGroup(FriendsGroup friendsGroup) {
        this.friendsGroup = friendsGroup;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Friend{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Friend friend = (Friend) o;
        return Objects.equals(name, friend.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

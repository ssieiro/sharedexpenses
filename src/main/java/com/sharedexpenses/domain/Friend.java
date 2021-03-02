package com.sharedexpenses.domain;

public class Friend {
    private final int friendId;
    private static int friendCounter;
    private String name;

    private Friend(){this.friendId = ++Friend.friendCounter;}

    public Friend (String name){
        this();
        this.name = name;
    }

    public int getFriendId() {
        return friendId;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Friend{" +
                "friendId=" + friendId +
                ", name='" + name + '\'' +
                '}';
    }
}

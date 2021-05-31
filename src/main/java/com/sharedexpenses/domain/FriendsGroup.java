package com.sharedexpenses.domain;

public class FriendsGroup {

    private long id;
    private String name;

    public FriendsGroup(){};

    public FriendsGroup(String name) {
        this.name = name;
    }

    public FriendsGroup(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
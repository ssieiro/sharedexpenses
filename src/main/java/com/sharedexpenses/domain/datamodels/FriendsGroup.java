package com.sharedexpenses.domain.datamodels;

public class FriendsGroup {

    private int id;
    private String name;

    public FriendsGroup(){};
    public FriendsGroup(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

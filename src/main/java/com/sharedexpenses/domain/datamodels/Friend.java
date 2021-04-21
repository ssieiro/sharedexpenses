package com.sharedexpenses.domain.datamodels;

import java.util.Objects;


public class Friend {

    private int id;

    private String name;

    public Friend(){}

    public Friend(String name) {
        this.name = name;
    }

    public int getId(){ return id; }

    public String getName() {
        return name;
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

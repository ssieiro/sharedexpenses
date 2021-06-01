package com.sharedexpenses.domain.dto;

import java.util.Objects;

public class FriendDTO {
    private long id;
    private String name;
    private long groupId;

    public FriendDTO(){}

    public FriendDTO(long id, String name, long groupId) {
        this.id = id;
        this.name = name;
        this.groupId = groupId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    public long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FriendDTO friendDTO = (FriendDTO) o;
        return groupId == friendDTO.groupId && id == friendDTO.id && Objects.equals(name, friendDTO.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, groupId, id);
    }
}

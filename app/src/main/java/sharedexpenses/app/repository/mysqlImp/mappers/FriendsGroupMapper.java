package sharedexpenses.app.repository.mysqlImp.mappers;


import org.apache.ibatis.annotations.Mapper;
import sharedexpenses.domain.FriendsGroup;

import java.util.List;

@Mapper
public interface FriendsGroupMapper {

    //SELECT ALL
    List findAllGroups();

    //SELECT BY ID
    FriendsGroup findGroupById(long id);

    List findFriendsByGroup(long groupId);

    List findPaymentsByFriend(long friendId);

    //INSERT
    void insertFriendsGroup(FriendsGroup friendsGroup);

    //DELETE
    void deleteGroupById(long id);

}

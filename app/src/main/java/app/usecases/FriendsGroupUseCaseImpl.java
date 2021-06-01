package app.usecases;

import app.repository.FriendsGroupRepository;
import domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendsGroupUseCaseImpl implements FriendsGroupUseCase {

    private final FriendsGroupRepository friendsGroupRepository;
    private final BalanceCalculator balanceCalculator;
    private final DebtCalculator debtCalculator;

    @Autowired
    public FriendsGroupUseCaseImpl(FriendsGroupRepository friendsGroupRepository, BalanceCalculator balanceCalculator, DebtCalculator debtCalculator){
        this.friendsGroupRepository = friendsGroupRepository;
        this.balanceCalculator = balanceCalculator;
        this.debtCalculator = debtCalculator;
    }

    // GET ALL
    @Override
    public List<FriendsGroup> getAllGroups() { return friendsGroupRepository.getAllGroups(); }

    //GET BY GROUPID
    @Override
    public FriendsGroup getGroupById(long id) {return friendsGroupRepository.getGroupById(id);}

    @Override
    public List<Friend> getFriendsByGroup(long groupId) { return friendsGroupRepository.getFriendsByGroup(groupId);}

    @Override
    public List<Payment> getPaymentsByGroup(long groupId) { return friendsGroupRepository.getPaymentsByGroup(groupId);}

    //CALCULATE
    @Override
    public List<Balance> calculateBalance(long groupId) {
        return balanceCalculator.calculateBalance(getPaymentsByGroup(groupId), getFriendsByGroup(groupId));
    }

    @Override
    public List<Debt> calculateDebts(long groupId) {
        return debtCalculator.calculateDebts(getPaymentsByGroup(groupId), getFriendsByGroup(groupId));
    }

    //ADD
    @Override
    public FriendsGroup addGroup(FriendsGroup group) { return friendsGroupRepository.addGroup(group);}

    @Override
    public void deleteGroup(long id) { friendsGroupRepository.deleteGroup(id);}

}


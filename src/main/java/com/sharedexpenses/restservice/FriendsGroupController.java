package com.sharedexpenses.restservice;

import com.sharedexpenses.domain.*;
import com.sharedexpenses.domain.converters.BalanceToDTO;
import com.sharedexpenses.domain.converters.DebtToDTO;
import com.sharedexpenses.domain.converters.FriendToDTO;
import com.sharedexpenses.domain.converters.PaymentToDTO;
import com.sharedexpenses.usecases.FriendsGroupUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class FriendsGroupController {

    private final FriendsGroupUseCase friendsGroupUseCase;

    @Autowired
    public FriendsGroupController(FriendsGroupUseCase friendsGroupUseCase) {
        this.friendsGroupUseCase = friendsGroupUseCase;
    }

    // GET ALL
    @GetMapping("/groups")
    public List<FriendsGroup> getAllGroups(){
        return friendsGroupUseCase.getAllGroups();
    }

    //GET BY GROUPID
    @GetMapping("/groups/{id}")
    public FriendsGroup getGroupById(@PathVariable long id){return friendsGroupUseCase.getGroupById(id);}

    @GetMapping("groups/{groupId}/friends")
    public List<FriendDTO> getFriendsByGroup(@PathVariable long groupId){
        List<Friend> friends = friendsGroupUseCase.getFriendsByGroup(groupId);
        List<FriendDTO> friendsDTO = new ArrayList<FriendDTO>();
        friends.forEach(friend -> {
            friendsDTO.add(FriendToDTO.convert(friend));
        });
        return friendsDTO;
    }

    @GetMapping("groups/{groupId}/payments")
    public List<PaymentDTO> getPaymentsByGroup(@PathVariable long groupId){
        List<Payment> payments = friendsGroupUseCase.getPaymentsByGroup(groupId);
        List<PaymentDTO> paymentsDTO = new ArrayList<>();
        payments.forEach(payment -> {
            paymentsDTO.add(PaymentToDTO.convert(payment));
        });
        return paymentsDTO;
    }

    //GET BALANCE AND DEBT
    @GetMapping("groups/{groupId}/balance")
    public List<BalanceDTO> calculateBalance(@PathVariable long groupId){
        List<Balance> balances = friendsGroupUseCase.calculateBalance(groupId);
        List<BalanceDTO> balancesDTO = new ArrayList<>();
        balances.forEach(balance -> {
            balancesDTO.add(BalanceToDTO.convert(balance));
        });
        return balancesDTO;
    }

    @GetMapping("groups/{groupId}/debts")
    public List<DebtDTO> calculateDebts(@PathVariable long groupId){
        List<Debt> debts = friendsGroupUseCase.calculateDebts(groupId);
        List<DebtDTO> debtsDTO = new ArrayList<>();
        debts.forEach(debt -> {
            debtsDTO.add(DebtToDTO.convert(debt));
        });
        return debtsDTO;
    }

    //POST
    @PostMapping("/groups")
    public FriendsGroup addGroup (@RequestBody FriendsGroup group) {
        return friendsGroupUseCase.addGroup(group);
    }

    //DELETE
    @DeleteMapping("/groups/{id}")
    public void deleteGroup (@PathVariable long id) { friendsGroupUseCase.deleteGroup(id); }

}

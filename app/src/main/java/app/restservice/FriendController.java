package app.restservice;

import domain.Friend;
import domain.converters.FriendConverter;
import domain.dto.FriendDTO;
import app.usecases.FriendUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class FriendController {

    private final FriendUseCase friendUseCase;

    @Autowired
    public FriendController(FriendUseCase friendUseCase) {
        this.friendUseCase = friendUseCase;
    }

    // GET ALL
    @GetMapping("/friends")
    public List<FriendDTO> getAllFriends(){
        List<Friend> friends = friendUseCase.getAllFriends();
        List<FriendDTO> friendsDTO = new ArrayList<FriendDTO>();
        friends.forEach(friend -> {
            friendsDTO.add(FriendConverter.toDTO(friend));
        });
        return friendsDTO;
    }

    //POST
    @PostMapping("/friends")
    public FriendDTO addFriend (@RequestBody FriendDTO friendDTO) {
        Friend friend = friendUseCase.addFriend(friendDTO);
        return FriendConverter.toDTO(friend);
    }

    //DELETE
    @DeleteMapping("/friends/{id}")
    public void deleteFriend (@PathVariable long id) {
        friendUseCase.deleteFriend(id);
    }

}

package de.telran.mytinder;
import de.telran.mytinder.repository.UserRepository;
import de.telran.mytinder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController//создается контроллер и управляется спрингом
public class UserController {

    //@Autowired//находит юзерСервайс в контексте приложения и внедряет зависимость
    private final UserService userService;
    private final UserRepository userRepository;
    private int count = 1;

    public UserController(@Autowired @Qualifier(value = "randomUserService") UserService userService, @Autowired UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @GetMapping(value = "/show-new-user")
    public User showNewUser() {
        count++;
        return userService.getUser();
    }

    @GetMapping(value="/show-all-users")
    public List<User> showAllUsers(){
        return userRepository.getUsers();
    }

    @GetMapping(value = "/count")
    public int showCount(){
        return count;
    }
}

package de.telran.mytinder.service;
import de.telran.mytinder.User;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
@Service
public class ShortNameUserService implements UserService{


    @Override
    public User getUser(List<User> users) {
        return users.stream()
                .min(Comparator.comparingInt(user -> user.getName().length()))
                .orElse(null);
    }

}

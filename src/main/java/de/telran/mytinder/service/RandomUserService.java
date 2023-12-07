package de.telran.mytinder.service;

import de.telran.mytinder.User;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Random;
@Service
public class RandomUserService implements UserService {
    @Override
    public User getUser(List<User> users) {
        Random random = new Random();
        return users.get(random.nextInt(users.size()));
    }
}

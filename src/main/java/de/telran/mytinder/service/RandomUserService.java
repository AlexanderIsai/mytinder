package de.telran.mytinder.service;

import de.telran.mytinder.User;
import de.telran.mytinder.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Random;
@Service
public class RandomUserService implements UserService {

    private final UserRepository userRepository;

    public RandomUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUser() {
        Random random = new Random();
        return userRepository.getUsers().get(random.nextInt(userRepository.getUsers().size()));
    }
}

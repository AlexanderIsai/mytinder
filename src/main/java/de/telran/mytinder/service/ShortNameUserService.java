package de.telran.mytinder.service;
import de.telran.mytinder.User;
import de.telran.mytinder.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
@Service
@RequiredArgsConstructor
public class ShortNameUserService implements UserService{

    private final UserRepository userRepository;


    @Override
    public User getUser() {
        return userRepository.getUsers().stream()
                .min(Comparator.comparingInt(user -> user.getName().length()))
                .orElse(null);
    }

}

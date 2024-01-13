package de.telran.mytinder.service.impl;

import de.telran.mytinder.entity.User;
import de.telran.mytinder.repository.UserRepository;
import de.telran.mytinder.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
@Service
@RequiredArgsConstructor
public class RandomUserService implements UserService {

//    private final UserRepositoryImpl userRepositoryImpl;
    private final UserRepository userRepository;


    @Override
    public User getUser() {
        List<User> users = userRepository.findAll();

        if(users == null || users.isEmpty()){
            throw new RuntimeException("No users found");
        }
        Random random = new Random();
        int randomIndex = random.nextInt(users.size());
        return users.get(randomIndex);
    }

    @Override
    public List<User> getByName(String name) {
        return null;
    }

    @Override
    public void save(User user) {

    }

    @Override
    public List<User> getBetweenRating(Integer from, Integer to) {
        return null;
    }

    @Override
    public List<User> getUsersWithStringInDescription(String string) {
        return null;
    }

    @Override
    public Integer getCountUsersWithStringInDescription(String string) {
        return null;
    }

    @Override
    public Boolean existsUserById(Long id) {
        return false;
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return null;
    }
}

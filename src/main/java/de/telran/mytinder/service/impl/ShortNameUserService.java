package de.telran.mytinder.service.impl;
import de.telran.mytinder.entity.User;
import de.telran.mytinder.repository.UserRepositoryImpl;
import de.telran.mytinder.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ShortNameUserService implements UserService {

    private final UserRepositoryImpl userRepositoryImpl;


    @Override
    public User getUser() {
        return userRepositoryImpl.getUsers().stream()
                .min(Comparator.comparingInt(user -> user.getName().length()))
                .orElse(null);
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

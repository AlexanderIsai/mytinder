package de.telran.mytinder.service.impl;
import de.telran.mytinder.entity.Photo;
import de.telran.mytinder.entity.User;
import de.telran.mytinder.repository.PhotoRepository;
import de.telran.mytinder.repository.UserRepository;
import de.telran.mytinder.repository.UserRepositoryImpl;
import de.telran.mytinder.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Primary
public class TopRatingUserService implements UserService {

    private final UserRepository userRepository;
    private final PhotoRepository photoRepository;

    @Override
    public User getUser() {
        List<User> users = userRepository.findAll();
        int maxRating = 0;
        User bestUser = null;
        if(users == null || users.isEmpty()){
            throw new RuntimeException("No users found");
        }
        for (User user : users) {
            if (user.getRating() > maxRating) {
                maxRating = user.getRating();
                bestUser = user;
            }
        }
        return bestUser;
    }

    @Override
    public List<User> getByName(String name) {
        List<Photo> photos = photoRepository.findAll();
        System.out.println(photos);
        List<User> users = userRepository.findAutocomplete3(name);

        return users;
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> getBetweenRating(Integer from, Integer to) {
        return userRepository.findUsersByRatingBetween(from, to);
    }

    @Override
    public List<User> getUsersWithStringInDescription(String string) {
        return userRepository.findUsersByDescriptionContainingIgnoreCase(string);
    }

    @Override
    public Integer getCountUsersWithStringInDescription(String string) {
        return userRepository.countUsersByDescriptionContainsIgnoreCase(string);
    }

    @Override
    public Boolean existsUserById(Long id) {
        return userRepository.existsUserById(id);
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

}

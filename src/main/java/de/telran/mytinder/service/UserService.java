package de.telran.mytinder.service;

import de.telran.mytinder.entity.User;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {


    User getUser();
    List<User> getByName(String name);

    void save(User user);

    List<User> getBetweenRating(Integer from, Integer to);

    List<User> getUsersWithStringInDescription(String string);

    Integer getCountUsersWithStringInDescription(String string);

    Boolean existsUserById(Long id);

    Page<User> findAll(Pageable pageable);

}

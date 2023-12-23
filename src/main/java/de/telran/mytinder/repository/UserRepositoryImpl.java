package de.telran.mytinder.repository;
import de.telran.mytinder.entity.User;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
@Getter
public class UserRepositoryImpl {

    private final List<User> users;

    public UserRepositoryImpl() {
        this.users = new ArrayList<>();
        initUsersTestData();
    }

    private void initUsersTestData() {
        users.addAll(new ArrayList<>(List.of(
                new User(1L, "Petr", 100, "Just Petr"),
                new User(2L, "Anna", 150, "like cats"),
                new User(3L, "Pavel", 200, "hate dogs"),
                new User(4L, "Bob", 220, "unfortunately, not Bean")
        )));
    }

}

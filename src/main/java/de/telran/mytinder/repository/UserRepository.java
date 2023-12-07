package de.telran.mytinder.repository;
import de.telran.mytinder.User;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
@Getter
public class UserRepository {

    private final List<User> users;

    public UserRepository() {
        this.users = new ArrayList<>();
        initUsersTestData();
    }

    private void initUsersTestData() {
        users.addAll(new ArrayList<>(List.of(
                new User(1, "Petr", 100, "Just Petr"),
                new User(2, "Anna", 150, "like cats"),
                new User(3, "Pavel", 200, "hate dogs"),
                new User(4, "Bob", 220, "unfortunately, not Bean")
        )));
    }

}

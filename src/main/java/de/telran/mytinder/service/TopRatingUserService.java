package de.telran.mytinder.service;
import de.telran.mytinder.User;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TopRatingUserService implements UserService{

    @Override
    public User getUser(List<User> users) {
        int maxRating = 0;
        User bestUser = null;
        for (User user : users) {
            if (user.getRating() > maxRating) {
                maxRating = user.getRating();
                bestUser = user;
            }
        }
        return bestUser;
    }
}

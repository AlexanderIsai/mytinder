package de.telran.mytinder.service;
import de.telran.mytinder.User;
import de.telran.mytinder.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TopRatingUserService implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUser() {
        int maxRating = 0;
        User bestUser = null;
        for (User user : userRepository.getUsers()) {
            if (user.getRating() > maxRating) {
                maxRating = user.getRating();
                bestUser = user;
            }
        }
        return bestUser;
    }
}

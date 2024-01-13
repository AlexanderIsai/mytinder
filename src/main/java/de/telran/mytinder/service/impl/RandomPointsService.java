package de.telran.mytinder.service.impl;


import de.telran.mytinder.entity.User;
import de.telran.mytinder.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class RandomPointsService {
    private final UserRepository userRepository;
    private final RandomUserService randomUserService;
    private final int POINTS = 13;

    @Scheduled(cron = "0 23 22 * * *")
    public void addPoints() {
        User user = randomUserService.getUser();
        user.setRating(user.getRating() + POINTS);
        userRepository.save(user);
        log.info(user.getName() + " получил " + POINTS + " баллов");
    }
    @Scheduled(cron = "0 23 22 * * *")
    public void takePoints() {
        User user = randomUserService.getUser();
        user.setRating(user.getRating() - POINTS);
        userRepository.save(user);
        log.info(user.getName() + " потерял " + POINTS + " баллов");
    }
}

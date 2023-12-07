package de.telran.mytinder;

import de.telran.mytinder.service.ShortNameUserService;
import de.telran.mytinder.service.TopRatingUserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MytinderApplication {

    public static void main(String[] args) {
        SpringApplication.run(MytinderApplication.class, args);
    }
}

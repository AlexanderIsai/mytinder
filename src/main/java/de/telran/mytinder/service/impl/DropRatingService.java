package de.telran.mytinder.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DropRatingService {

//    @Scheduled(fixedRate = 1000)
//    @Scheduled(fixedDelay = 1000)
    @Scheduled(cron = "0/5 * * * * *")
    public void test() throws InterruptedException {
        log.info("hello");
    }
}

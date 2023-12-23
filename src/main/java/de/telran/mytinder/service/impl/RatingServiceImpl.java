package de.telran.mytinder.service.impl;

import de.telran.mytinder.entity.User;
import de.telran.mytinder.repository.UserRepository;
import de.telran.mytinder.service.RatingService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RatingServiceImpl implements RatingService {
    private final UserRepository userRepository;
    @Transactional
    @Override
    public void shareRating(Long fromId, Long toId, Integer countRating) {
        Optional<User> fromUserOptional = userRepository.findById(fromId);
        Optional<User> toUserOptional = userRepository.findById(toId);

        if(fromUserOptional.isPresent() && toUserOptional.isPresent()){
            User fromUser = fromUserOptional.get();
            User toUser = toUserOptional.get();
            fromUser.setRating(fromUser.getRating() - countRating);
            toUser.setRating(toUser.getRating() + countRating);
            userRepository.save(fromUser);
            userRepository.save(toUser);
        }
    }
}

package de.telran.mytinder.service;

public interface RatingService {
    void shareRating(Long fromId, Long toId, Integer countRating);
}

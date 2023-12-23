package de.telran.mytinder.controller;

import de.telran.mytinder.ShareRatingDto;
import de.telran.mytinder.service.RatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RatingController {
    private final RatingService ratingService;

    ///share/from/daniil/to/anna/count/1000
    @PostMapping(value = "/share")
    public void shareRating(@RequestBody ShareRatingDto shareRatingDto) {
        ratingService.shareRating(shareRatingDto.getFromId(), shareRatingDto.getToId(), shareRatingDto.getCountRating());
    }
}

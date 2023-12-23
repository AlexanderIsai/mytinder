package de.telran.mytinder;

import lombok.Data;

@Data
public class ShareRatingDto {

    private Long fromId;
    private Long toId;
    private Integer countRating;
}

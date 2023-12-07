package de.telran.mytinder;

import lombok.*;

//POJO
@Data
@AllArgsConstructor
public class User {

    private long id;
    private String name;
    private int rating;
    private String description;
}

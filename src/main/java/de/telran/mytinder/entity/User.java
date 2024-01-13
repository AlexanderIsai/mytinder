package de.telran.mytinder.entity;

import jakarta.persistence.*;
import lombok.*;

//POJO
@Data
@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "rating")
    private int rating;
    @Column(name = "description")
    private String description;
}

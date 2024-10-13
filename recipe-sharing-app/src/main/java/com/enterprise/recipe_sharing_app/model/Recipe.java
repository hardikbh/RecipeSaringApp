package com.enterprise.recipe_sharing_app.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;

    @ManyToOne
    private User user;

    private String description;

    private String image;

    private boolean  vegetarian;

    private LocalDateTime createdAt;

    private List<Long> likes = new ArrayList<>();


}

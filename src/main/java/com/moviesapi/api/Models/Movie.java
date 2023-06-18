package com.moviesapi.api.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String movie_name;

    @Column
    private String genre;

    @Column
    private String releaseYear;
}

package com.moviesapi.api.Repository;

import com.moviesapi.api.Models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepo extends JpaRepository<Movie, Long> {
}

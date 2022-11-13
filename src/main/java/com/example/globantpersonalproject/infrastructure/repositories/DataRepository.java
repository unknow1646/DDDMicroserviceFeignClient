package com.example.globantpersonalproject.infrastructure.repositories;

import com.example.globantpersonalproject.domain.entities.Movie;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataRepository extends JpaRepository<Movie, Long> {

  Optional<Movie> findByTitle (String movieTitle);

}

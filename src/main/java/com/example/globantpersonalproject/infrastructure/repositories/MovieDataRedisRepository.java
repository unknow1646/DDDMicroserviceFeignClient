package com.example.globantpersonalproject.infrastructure.repositories;

import com.example.globantpersonalproject.domain.entities.Movie;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieDataRedisRepository extends JpaRepository<Movie, String> {

  List<Movie> findAll();
}

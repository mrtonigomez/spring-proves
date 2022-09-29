package com.example.springproves.repositories;

import com.example.springproves.models.filmfy.Entities;
import com.example.springproves.models.filmfy.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    List<Movie> findTop30ByOrderByIdDesc();

    @Query(value = "SELECT * FROM entities as e JOIN entities_movies as em on em.entities_id = e.id JOIN movies as m ON m.id = em.movies_id WHERE m.id = :id", nativeQuery = true)
    List<Movie> getMoviesEntities(Long id);

}
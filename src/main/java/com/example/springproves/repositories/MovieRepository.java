package com.example.springproves.repositories;

import com.example.springproves.models.filmfy.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {


    /*@Query("select m from Movie m where m.categories = ?1")
    List<Movie> ca*/
}
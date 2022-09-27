package com.example.springproves.repositories;

import com.example.springproves.models.filmfy.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    List<Movie> findTop30ByOrderByIdDesc();

    /*List<Movie> findByEntities();*/

}
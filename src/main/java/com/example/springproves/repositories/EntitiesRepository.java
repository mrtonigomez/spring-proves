package com.example.springproves.repositories;

import com.example.springproves.models.filmfy.Entities;
import com.example.springproves.models.filmfy.Movie;
import com.example.springproves.models.filmfy.Role;
import com.example.springproves.services.MovieService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntitiesRepository extends JpaRepository<Entities, Long> {

    List<Entities> findByRolesId(Long id);

    /*List<Entities> findByRolesIdAndMoviesEquals(Long id, Movie movie);*/

    List<Entities> findByNameContaining(String name);

}
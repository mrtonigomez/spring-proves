package com.example.springproves.services;

import com.example.springproves.dto.CommentCreateDTO;
import com.example.springproves.models.filmfy.Comment;
import com.example.springproves.models.filmfy.Entities;
import com.example.springproves.models.filmfy.Movie;
import com.example.springproves.models.filmfy.User;
import com.example.springproves.repositories.CommentRepository;
import com.example.springproves.repositories.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MovieService {

    protected final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAll() {
        return movieRepository.findAll();
    }

    public Movie getById(Long id) {
        return movieRepository.findById(id).get();
    }

    public List<Movie> getAllLimit30() {
        return movieRepository.findTop30ByOrderByIdDesc();
    }

    public Set<String> getNameEntities(Set<Entities> entities){
        return entities.stream().map(Entities::getName).collect(Collectors.toSet());
    }

}

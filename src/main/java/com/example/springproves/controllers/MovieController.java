package com.example.springproves.controllers;

import com.example.springproves.dto.MovieDTO;
import com.example.springproves.services.MapStructMapper;
import com.example.springproves.services.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class MovieController {

    protected final MovieService movieService;
    MapStructMapper mapStructMapper;

    public MovieController(MovieService movieService, MapStructMapper mapStructMapper) {
        this.movieService = movieService;
        this.mapStructMapper = mapStructMapper;
    }

    @GetMapping("/movies")
    public List<MovieDTO> getGameDetails() {
        return movieService.getAll()
                .stream()
                .map(movie -> mapStructMapper.movieToMovieDto(movie))
                .collect(Collectors.toList());
    }


}

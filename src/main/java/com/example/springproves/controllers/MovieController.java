package com.example.springproves.controllers;

import com.example.springproves.dto.MovieDTO;
import com.example.springproves.models.filmfy.Movie;
import com.example.springproves.services.MapStructMapper;
import com.example.springproves.services.MovieService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class MovieController {

    private ModelMapper modelMapper;
    protected final MovieService movieService;
    MapStructMapper mapStructMapper;

    public MovieController(MovieService movieService, MapStructMapper mapStructMapper, ModelMapper modelMapper) {
        this.movieService = movieService;
        this.mapStructMapper = mapStructMapper;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/movies")
    public List<MovieDTO> getMovies() {
        return movieService.getAllLimit30()
                .stream()
                .map(movie -> mapStructMapper.movieToMovieDto(movie))
                .collect(Collectors.toList());
    }

    @GetMapping("/movies2")
    public List<MovieDTO> getMovies2() {
        List<Movie> movies = movieService.getAll();
        return movies
                .stream()
                .map(movie -> mapStructMapper.movieToMovieDto(movie))
                .collect(Collectors.toList());
    }

    @GetMapping("/movies/{id}")
    public MovieDTO getMoviesById(@PathVariable String id) {
        Movie movie = movieService.getById((long) Integer.parseInt(id));
        return mapStructMapper.movieToMovieDto(movie);
    }

    @GetMapping("/movies-paginate")
    public List<MovieDTO> getMoviesPaginated(@RequestParam String page) {

        Page<Movie> movies = movieService.getAllPaginated(Integer.parseInt(page));
        return movies
                .stream()
                .map(movie -> mapStructMapper.movieToMovieDto(movie))
                .collect(Collectors.toList());
    }


}

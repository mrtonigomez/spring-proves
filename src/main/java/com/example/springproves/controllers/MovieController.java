package com.example.springproves.controllers;

import com.example.springproves.dto.ListsDTO;
import com.example.springproves.dto.MovieDTO;
import com.example.springproves.dto.Request.MovieRequestDTO;
import com.example.springproves.models.filmfy.Lists;
import com.example.springproves.models.filmfy.Movie;
import com.example.springproves.services.MapStructMapper;
import com.example.springproves.services.MovieService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

import java.util.List;
import java.util.Set;
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

    @GetMapping("/movie-include-list/{id}")
    public Set<ListsDTO> movieIncludeList(@PathVariable String id) {

        Movie movie = movieService.getById((long) Integer.parseInt(id));
        Set<Lists> listsSet = movie.getLists();

        return mapStructMapper.listToListDTO(listsSet);
    }

    @GetMapping("/movies-paginate")
    public List<MovieDTO> getMoviesPaginated(@RequestParam String page) {

        Page<Movie> movies = movieService.getAllPaginated(Integer.parseInt(page));
        return movies
                .stream()
                .map(movie -> mapStructMapper.movieToMovieDto(movie))
                .collect(Collectors.toList());
    }

    @PostMapping("/movies")
    public ResponseEntity insertMovies(@Valid @RequestBody MovieRequestDTO movieRequestDTO) {

        movieService.insertMovie(movieRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Insert guay");

    }

    @GetMapping("/movie-test")
    public List<Movie> movieIncludeList() {

        Movie movie = movieService.getById(1L);

        List<Movie> movies = movieService.testingQueries(1L);

        return movies;
    }


}

package com.example.springproves.services;

import com.example.springproves.dto.CommentCreateDTO;
import com.example.springproves.dto.Request.MovieRequestDTO;
import com.example.springproves.models.filmfy.Comment;
import com.example.springproves.models.filmfy.Entities;
import com.example.springproves.models.filmfy.Movie;
import com.example.springproves.models.filmfy.User;
import com.example.springproves.repositories.CommentRepository;
import com.example.springproves.repositories.MovieRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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

    public Page<Movie> getAllPaginated(int page) {
        return movieRepository.findAll(PageRequest.of(page, 25));
    }

    public void insertMovie(MovieRequestDTO movieRequestDTO) {

        Movie movie = new Movie();

        /*movieRequestDTO.toString()*/

        movie.setTitle(movieRequestDTO.getTitle());
        movie.setDescription(movieRequestDTO.getDescription());
        movie.setReleaseDate(movieRequestDTO.getReleaseDate());
        movie.setImage(movieRequestDTO.getImage());
        movie.setRuntime(movieRequestDTO.getRuntime());

        movieRepository.save(movie);

    }

    public List<Movie> testingQueries(Long id) {
        return movieRepository.getMoviesEntities(id);
    }

}

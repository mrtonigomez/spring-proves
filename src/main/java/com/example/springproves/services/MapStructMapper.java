package com.example.springproves.services;

import com.example.springproves.EntitiesDTO;
import com.example.springproves.dto.*;
import com.example.springproves.models.filmfy.*;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class MapStructMapper {

    private ModelMapper modelMapper;
    protected MovieService movieService;
    protected EntitiesService entitiesService;

    public MapStructMapper(MovieService movieService, EntitiesService entitiesService, ModelMapper modelMapper) {
        this.movieService = movieService;
        this.entitiesService = entitiesService;
        this.modelMapper = modelMapper;
    }

    public CommentDTO commentToCommentDTO(Comment comment) {

        CommentDTO commentDTO = new CommentDTO();

        commentDTO.setId(comment.getId());
        commentDTO.setBody(comment.getBody());
        commentDTO.setTitle(comment.getTitle());
        commentDTO.setUserDTO(userToUserDto(comment.getUser()));

        return commentDTO;
    }

    public UserDTO userToUserDto(User user) {

        UserDTO userDTO = new UserDTO();

        userDTO.setId(user.getId());
        userDTO.setEmail(user.getEmail());
        userDTO.setName(user.getName());

        return userDTO;
    }

    public MovieDTO movieToMovieDto(Movie movie) {

        MovieDTO movieDTO = new MovieDTO();

        movieDTO.setTitle(movie.getTitle());
        movieDTO.setDescription(movie.getDescription());
        movieDTO.setImage(movie.getImage());
        movieDTO.setRuntime(movie.getRuntime());
        movieDTO.setReleaseDate(movie.getReleaseDate());

        Set<String> categories = movie.getCategories()
                .stream()
                .map(Category::getName)
                .collect(Collectors.toSet());

        Set<String> actors = movie.getEntities()
                .stream()
                .filter(entities -> entities.getRoles().getId().equals(1L))
                .map(Entities::getName)
                .collect(Collectors.toSet());

        Set<String> directors = movie.getEntities()
                .stream()
                .filter(entities -> entities.getRoles().getId().equals(2L))
                .map(Entities::getName)
                .collect(Collectors.toSet());

        Set<String> writters = movie.getEntities()
                .stream()
                .filter(entities -> entities.getRoles().getId().equals(3L))
                .map(Entities::getName)
                .collect(Collectors.toSet());

        movieDTO.setCategories(categories);
        movieDTO.setActors(actors);
        movieDTO.setDirectos(directors);
        movieDTO.setWritters(writters);

        return movieDTO;
    }

    public Set<ListsDTO> listToListDTO(Set<Lists> lists) {

        Set<ListsDTO> returnList = new HashSet<>();

        lists.forEach(lists1 -> {
            ListsDTO listsDTO = new ListsDTO();

            listsDTO.setTitle(lists1.getTitle());
            listsDTO.setId(lists1.getId());
            listsDTO.setPrivate(lists1.getIsPrivate());

            List<String> movieDTOList = lists1.getMovies()
                    .stream()
                    .map(movie -> {
                        return modelMapper.map(movie, MovieForListDTO.class).getTitle();
                    })
                    .collect(Collectors.toList());

            listsDTO.setMovieDTOList(movieDTOList);
            returnList.add(listsDTO);
        });

        return returnList;
    }

}

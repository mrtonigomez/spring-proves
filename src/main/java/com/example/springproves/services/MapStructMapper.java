package com.example.springproves.services;

import com.example.springproves.dto.CommentDTO;
import com.example.springproves.dto.ListsDTO;
import com.example.springproves.dto.MovieDTO;
import com.example.springproves.dto.UserDTO;
import com.example.springproves.models.filmfy.Comment;
import com.example.springproves.models.filmfy.Lists;
import com.example.springproves.models.filmfy.Movie;
import com.example.springproves.models.filmfy.User;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class MapStructMapper
{

    protected MovieService movieService;

    public MapStructMapper(MovieService movieService) {
        this.movieService = movieService;
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

        Set<String> categories = movie.getCategories().stream().map(category -> category.getName()).collect(Collectors.toSet());
        movieDTO.setCategories(categories);

        return movieDTO;
    }

    public Set<ListsDTO> listToListDTO(Set<Lists> lists) {

        Set<ListsDTO> returnList = new HashSet<>();

        lists.forEach(lists1 -> {
            ListsDTO listsDTO = new ListsDTO();

            listsDTO.setTitle(lists1.getTitle());
            listsDTO.setId(lists1.getId());
            listsDTO.setPrivate(lists1.getIsPrivate());

            returnList.add(listsDTO);
        });



        return returnList;
    }

}

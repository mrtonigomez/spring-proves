package com.example.springproves.services;

import com.example.springproves.dto.CommentCreateDTO;
import com.example.springproves.models.filmfy.Comment;
import com.example.springproves.models.filmfy.Movie;
import com.example.springproves.models.filmfy.User;
import com.example.springproves.repositories.CommentRepository;
import com.example.springproves.repositories.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    protected final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAll() {
        return movieRepository.findAll();
    }

    /*public List<>*/

    /*public Comment getCommentById(Long id) {
        return commentRepository.findByIdCustom(id);
    }

    public List<Comment> getCommentByUsers(User user) {
        return commentRepository.getCommentByUsers(user);
    }

    public void insertComment(CommentCreateDTO comment, User user) {

        Comment commentToSave = new Comment();
        commentToSave.setUser(user);
        commentToSave.setBody(comment.getBody());
        commentToSave.setTitle(comment.getTitle());
        commentToSave.setRating(comment.getRating());
        commentToSave.setModerated(comment.getModerated());
        commentToSave.setStatus(comment.getStatus());
        commentToSave.setLikes(comment.getLikes());

        commentRepository.save(commentToSave);
    }*/

}

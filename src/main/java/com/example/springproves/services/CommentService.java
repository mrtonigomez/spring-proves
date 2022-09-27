package com.example.springproves.services;

import com.example.springproves.dto.CommentCreateDTO;
import com.example.springproves.models.filmfy.Comment;
import com.example.springproves.models.filmfy.User;
import com.example.springproves.repositories.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    protected final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public List<Comment> getAll() {
        return commentRepository.findAll();
    }

    public Comment getCommentById(Long id) {
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
    }

}

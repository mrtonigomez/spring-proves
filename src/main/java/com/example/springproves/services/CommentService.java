package com.example.springproves.services;

import com.example.springproves.dto.CommentCreateDTO;
import com.example.springproves.dto.CommentDTO;
import com.example.springproves.dto.UserDTO;
import com.example.springproves.models.filmfy.Comment;
import com.example.springproves.models.filmfy.User;
import com.example.springproves.repositories.CommentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CommentService {

    protected final CommentRepository commentRepository;
    private ModelMapper modelMapper;

    public CommentService(CommentRepository commentRepository, ModelMapper modelMapper) {
        this.commentRepository = commentRepository;
        this.modelMapper = modelMapper;
    }

    public List<CommentDTO> getAllReturnDTO() {
        return commentRepository.findAll().stream()
                .map(comment -> {
                    CommentDTO commentDTO = modelMapper.map(comment, CommentDTO.class);
                    commentDTO.setUserDTO(modelMapper.map(comment.getUser(), UserDTO.class));
                    return commentDTO;
                })
                .collect(Collectors.toList());
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

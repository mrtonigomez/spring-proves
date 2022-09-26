package com.example.springproves.services;

import com.example.springproves.models.Comment;
import com.example.springproves.repositories.CommentDetailsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class CommentService {

    protected final CommentDetailsRepository commentDetailsRepository;

    public CommentService(CommentDetailsRepository commentDetailsRepository) {
        this.commentDetailsRepository = commentDetailsRepository;
    }

    public List<Comment> getAll() {
        return commentDetailsRepository.findAll();
    }

}

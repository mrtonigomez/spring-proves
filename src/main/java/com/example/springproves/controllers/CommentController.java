package com.example.springproves.controllers;


import com.example.springproves.models.Comment;
import com.example.springproves.services.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class CommentController {
    protected final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/comments")
    @ResponseBody
    public List<Comment> firstEndpoint() {
        return commentService.getAll();
    }

}
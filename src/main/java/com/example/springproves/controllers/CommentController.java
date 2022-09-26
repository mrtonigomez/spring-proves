package com.example.springproves.controllers;


import com.example.springproves.dto.CommentCreateDTO;
import com.example.springproves.dto.CommentDTO;
import com.example.springproves.models.filmfy.Comment;
import com.example.springproves.models.filmfy.User;
import com.example.springproves.services.CommentService;
import com.example.springproves.services.MapStructMapper;
import com.example.springproves.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class CommentController {

    private ModelMapper modelMapper;
    protected final CommentService commentService;
    protected final UserService userService;
    private final MapStructMapper mapStructMapper;

    public CommentController(CommentService commentService, UserService userService, MapStructMapper mapStructMapper) {
        this.commentService = commentService;
        this.userService = userService;
        this.mapStructMapper = mapStructMapper;
    }

    @GetMapping("/comments")
    @ResponseBody
    public ResponseEntity getComments() {

        Optional<User> user = userService.getById(1L);

        List<Comment> bodies = commentService.getCommentByUsers(user);

        return ResponseEntity.ok(commentService.getAll()
                .stream()
                .map(mapStructMapper::commentToCommentDTO)
                .collect(Collectors.toList()));
    }

    @GetMapping("/comments/{user}")
    @ResponseBody
    public ResponseEntity getBodies(@PathVariable String user) {

        Optional<User> userFind = userService.getById((long) Integer.parseInt(user));

        List<Comment> comments = commentService.getCommentByUsers(userFind);

        if (comments.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Este usuario no ha realizado ningún comentario");
        }

        return ResponseEntity.ok(comments
                .stream()
                .map(mapStructMapper::commentToCommentDTO)
                .collect(Collectors.toList()));
    }

    @PostMapping("/comments")
    public ResponseEntity saveComment(@RequestBody CommentCreateDTO comment) {

        Optional<User> userFind = userService.getById((long) comment.getUserId());
        commentService.insertComment(comment, userFind.get());

        return ResponseEntity.ok("Insert correcto");
    }

}
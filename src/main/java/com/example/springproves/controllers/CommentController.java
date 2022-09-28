package com.example.springproves.controllers;


import com.example.springproves.dto.CommentCreateDTO;
import com.example.springproves.dto.CommentCustomDTO;
import com.example.springproves.dto.CommentDTO;
import com.example.springproves.dto.UserDTO;
import com.example.springproves.models.filmfy.Comment;
import com.example.springproves.models.filmfy.User;
import com.example.springproves.services.CommentService;
import com.example.springproves.services.MapStructMapper;
import com.example.springproves.services.UserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
public class CommentController {

    private ModelMapper modelMapper;
    protected final CommentService commentService;
    protected final UserService userService;
    private final MapStructMapper mapStructMapper;

    public CommentController(CommentService commentService, UserService userService, MapStructMapper mapStructMapper, ModelMapper modelMapper) {
        this.commentService = commentService;
        this.userService = userService;
        this.mapStructMapper = mapStructMapper;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/comments")
    @ResponseBody
    public ResponseEntity getComments() {

        Optional<User> user = userService.getById(1L);

        List<Comment> bodies = commentService.getCommentByUsers(user.get());

        return ResponseEntity.ok(commentService.getAllReturnDTO());
    }

    @GetMapping("/comments/{user}")
    @ResponseBody
    public ResponseEntity getCommentsByUser(@PathVariable String user) {

        Optional<User> userFind = userService.getById((long) Integer.parseInt(user));

        List<Comment> comments = commentService.getCommentByUsers(userFind.get());

        if (comments.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Este usuario no ha realizado ningún comentario");
        }

        return ResponseEntity.ok(comments
                .stream()
                .map(comment -> {
                    CommentDTO commentDTO = modelMapper.map(comment, CommentDTO.class);
                    commentDTO.setUserDTO(modelMapper.map(comment.getUser(), UserDTO.class));
                    return commentDTO;
                })
                .collect(Collectors.toList()));
    }

    @PostMapping("/comments")
    @ResponseBody
    public ResponseEntity saveComment(@RequestBody CommentCreateDTO comment) {

        Optional<User> userFind = userService.getById((long) comment.getUserId());
        commentService.insertComment(comment, userFind.get());

        return ResponseEntity.ok("Insert correcto");
    }

    @GetMapping("/custom-comments/{id}")
    @ResponseBody
    public ResponseEntity customComments(@PathVariable String id) {

        Comment comment = commentService.getCommentById(Long.valueOf(id));

        CommentDTO commentDTO = modelMapper.map(comment, CommentDTO.class);
        commentDTO.setUserDTO(modelMapper.map(comment.getUser(), UserDTO.class));

        return ResponseEntity.ok(commentDTO);
    }

    @GetMapping("/get-comments-another-way")
    @ResponseBody
    public ResponseEntity customCommentsAnotherWay() {

        List<Comment> comments = commentService.getAll();

        List<Map<String, Object>> commentList = new ArrayList<>();

        comments.forEach(comment -> {
            Map<String, Object> commentMap = new HashMap<>();

            commentMap.put("id", comment.getTitle());
            commentMap.put("title", comment.getTitle());
            commentMap.put("body", comment.getBody());
            commentMap.put("user", mapStructMapper.userToUserDto(comment.getUser()));

            commentList.add(commentMap);
        });

        return ResponseEntity.status(HttpStatus.OK).body(commentList);
    }

}
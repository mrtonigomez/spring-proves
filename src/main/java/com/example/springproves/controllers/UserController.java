package com.example.springproves.controllers;

import com.example.springproves.models.Comment;
import com.example.springproves.models.User;
import com.example.springproves.services.CommentService;
import com.example.springproves.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    protected final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

        @GetMapping("/users")
    @ResponseBody
    public List<User> firstEndpoint() {
        return userService.getAll();
    }
}

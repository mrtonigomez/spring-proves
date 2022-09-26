package com.example.springproves.controllers;

import com.example.springproves.dto.CommentDTO;
import com.example.springproves.dto.UserDTO;
import com.example.springproves.models.filmfy.User;
import com.example.springproves.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UserController {

    @Autowired
    ModelMapper modelMapper;

    protected final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    @ResponseBody
    public List<UserDTO> getUsers() {
        return userService.getAll().stream().map(user -> modelMapper.map(user, UserDTO.class))
                .collect(Collectors.toList());
    }
}

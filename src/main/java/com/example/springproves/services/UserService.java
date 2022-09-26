package com.example.springproves.services;

import com.example.springproves.models.Comment;
import com.example.springproves.models.User;
import com.example.springproves.repositories.CommentDetailsRepository;
import com.example.springproves.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    protected final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User>getAll() {
        return userRepository.findAll();
    }

}

package com.example.springproves.services;

import com.example.springproves.dto.CommentDTO;
import com.example.springproves.dto.UserDTO;
import com.example.springproves.models.filmfy.Comment;
import com.example.springproves.models.filmfy.User;
import org.springframework.stereotype.Component;

@Component
public class MapStructMapper
{

    public CommentDTO commentToCommentDTO(Comment comment) {

        CommentDTO commentDTO = new CommentDTO();

        commentDTO.setId(comment.getId());
        commentDTO.setBody(comment.getBody());
        commentDTO.setTitle(comment.getTitle());
        commentDTO.setUserDTO(userToUserDto(comment.getUser()));

        return commentDTO;
    }

    public UserDTO userToUserDto(User user) {

        UserDTO userDTO = new UserDTO();

        userDTO.setId(user.getId());
        userDTO.setEmail(user.getEmail());
        userDTO.setName(user.getName());

        return userDTO;
    }

}

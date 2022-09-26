package com.example.springproves.dto;


import com.fasterxml.jackson.annotation.JsonProperty;

public class CommentDTO {

    Long id;
    @JsonProperty("user")
    UserDTO userDTO;
    String title;
    String body;

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

}

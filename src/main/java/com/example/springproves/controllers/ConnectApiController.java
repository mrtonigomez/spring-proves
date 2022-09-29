package com.example.springproves.controllers;

import com.example.springproves.models.filmfy.Movie;
import com.example.springproves.services.ConnectApiSerrvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class ConnectApiController {

    @Autowired
    ConnectApiSerrvice connectApiSerrvice;

    @GetMapping("/connect-api")
    public List<Map<String, Object>> connectApi() {

        return connectApiSerrvice.getMoviesConnectApi();

    }

    @GetMapping("/post-movie-to-list")
    public Object postMovieToList() {

        LinkedHashMap user = connectApiSerrvice.login();
        return connectApiSerrvice.addMovieToList(String.valueOf(user.get("token")));

    }
}

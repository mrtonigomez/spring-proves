package com.example.springproves.controllers;

import com.example.springproves.models.Movie;
import com.example.springproves.services.ConnectApiSerrvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@RestController
public class ConnectApiController {

    @Autowired
    ConnectApiSerrvice connectApiSerrvice;

    @GetMapping("/connect-api")
    public List<Map<String, Object>> connectApi() {

        String URL_API = "http://filmfy-api.ddns.net/api/only-all-movies";

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<List<Movie>> responseEntity = restTemplate.
                exchange(URL_API, HttpMethod.GET, null, new ParameterizedTypeReference<>() {
                });

        List<Movie> movies = responseEntity.getBody();

        List<Map<String, Object>> list = new ArrayList<>();

        for (int i = 0; i < movies.size(); i++) {

            Map<String, Object> map = new HashMap<>();
            map.put("id", movies.get(i).getId());
            map.put("title", movies.get(i).getTitle());
            map.put("description", movies.get(i).getDescription());

            list.add(map);
        }
        return list;
    }

    @GetMapping("/post-movie-to-list")
    public Object postMovieToList() {

        LinkedHashMap user = connectApiSerrvice.login();
        return connectApiSerrvice.addMovieToList(String.valueOf(user.get("token")));

    }
}

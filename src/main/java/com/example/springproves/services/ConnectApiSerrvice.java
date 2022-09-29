package com.example.springproves.services;

import com.example.springproves.models.filmfy.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class ConnectApiSerrvice {

    @Autowired
    RestTemplate restTemplate;

    public List<Map<String, Object>> getMoviesConnectApi() {

        String URL_API = "http://filmfy-api.ddns.net/api/only-all-movies";

        ResponseEntity<List<Movie>> responseEntity = restTemplate.
                exchange(URL_API, HttpMethod.GET, null, new ParameterizedTypeReference<>() {});

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

    public LinkedHashMap login() {
        String URL_API = "http://filmfy-api.ddns.net/api/v1/login";

        // request body parameters
        Map<String, Object> map = new HashMap<>();
        map.put("email", "tonigomez@email.com");
        map.put("password", "password");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        // build the request
        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(map, headers);

        ResponseEntity<Object> login = restTemplate.
                postForEntity(URL_API, entity, Object.class);

        return (LinkedHashMap) login.getBody();

    }

    public String addMovieToList(String token) {

        String URL_API = "http://filmfy-api.ddns.net/api/v1/add-movie-to-list";

        // request body parameters
        Map<String, Object> map = new HashMap<>();
        map.put("lists_id", "1");
        map.put("movies_id", "134");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.setBearerAuth(String.valueOf(token));

        // build the request
        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(map, headers);

        ResponseEntity<String> response = restTemplate.
                postForEntity(URL_API, entity, String.class);

        return response.getBody();

    }

}

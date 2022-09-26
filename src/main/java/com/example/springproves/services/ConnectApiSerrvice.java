package com.example.springproves.services;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class ConnectApiSerrvice {

    public LinkedHashMap login() {
        String URL_API = "http://filmfy-api.ddns.net/api/v1/login";

        RestTemplate restTemplate = new RestTemplate();

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

        RestTemplate restTemplate = new RestTemplate();

        // request body parameters
        Map<String, Object> map = new HashMap<>();
        map.put("lists_id", "4");
        map.put("movies_id", "6");

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

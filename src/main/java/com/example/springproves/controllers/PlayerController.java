package com.example.springproves.controllers;


import com.example.springproves.models.Player;
import com.example.springproves.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class PlayerController {
    @Autowired
    PlayerService playerService;

    @GetMapping("/endpoint")
    public ArrayList<Player> firstEndpoint() {

        return playerService.getPlayers();
    }

    @PostMapping("/create-player")
    public Player createPlayer(@RequestBody Player player) {
        return playerService.createPlayer(player);
    }
}
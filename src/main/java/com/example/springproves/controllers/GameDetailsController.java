package com.example.springproves.controllers;

import com.example.springproves.models.GamesDetails;
import com.example.springproves.services.GameDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class GameDetailsController {

    protected final GameDetailsService gameDetailsService;

    public GameDetailsController(GameDetailsService gameDetailsService) {
        this.gameDetailsService = gameDetailsService;
    }

    @GetMapping("/game-details")
    public List<GamesDetails> getGameDetails() {
        return gameDetailsService.getGameDetails();
    }

    @GetMapping("/game-details-test")
    public Optional<GamesDetails> getGameDetailsTest() {

        Optional<GamesDetails> gamesDetails = gameDetailsService.getGameDetailsTest(3);
        return gamesDetails;
    }

}

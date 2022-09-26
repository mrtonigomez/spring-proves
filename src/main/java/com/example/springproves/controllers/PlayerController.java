package com.example.springproves.controllers;


import com.example.springproves.models.massiv_db.Player;
import com.example.springproves.services.PlayerService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class PlayerController {
    protected final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/player")
    public ArrayList<Player> firstEndpoint() {
        return playerService.getPlayers();
    }

    @PostMapping("/player")
    public Player createPlayer(@RequestBody Player player) {
        return playerService.createPlayer(player);
    }

    /*@DeleteMapping("/player/{id}")
    public ResponseEntity deletePlayer(@PathVariable Long id) {
        playerService.deletePlayer(id);
        return ResponseEntity.ok("Okey lord");
    }*/

}
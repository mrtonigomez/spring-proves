package com.example.springproves.services;

import com.example.springproves.models.Player;
import com.example.springproves.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Service
public class PlayerService {
    @Autowired
    PlayerRepository playerRepository;

    public ArrayList<Player> getPlayers() {
        return (ArrayList<Player>) playerRepository.findAll();
    }

    public Player createPlayer(Player player) {
        return playerRepository.save(player);
    }
}

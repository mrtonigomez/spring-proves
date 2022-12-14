package com.example.springproves.services;

import com.example.springproves.models.massiv_db.Player;
import com.example.springproves.repositories.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PlayerService {
    protected final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public ArrayList<Player> getPlayers() {
        return (ArrayList<Player>) playerRepository.findAll();
    }

    public Player createPlayer(Player player) {
        return playerRepository.save(player);
    }

    public void deletePlayer(Long id) {
        playerRepository.deleteById(id);
    }
}

package com.example.springproves.services;

import com.example.springproves.models.GamesDetails;
import com.example.springproves.repositories.GameDetailsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameDetailsService {

    protected final GameDetailsRepository gameDetailsRepository;

    public GameDetailsService(GameDetailsRepository gameDetailsRepository) {
        this.gameDetailsRepository = gameDetailsRepository;
    }

    public List<GamesDetails> getGameDetails() {
        return (List<GamesDetails>) gameDetailsRepository.getAllDetails();
    }

    public Optional<GamesDetails> getGameDetailsTest(int id) {
        return gameDetailsRepository.findById(id);
    }

}

package com.example.springproves.repositories;

import com.example.springproves.models.GamesDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameDetailsRepository extends JpaRepository<GamesDetails, Integer> {

    @Query(
            value = "SELECT * FROM games_details_csv LIMIT 100000",
            nativeQuery = true
    )
    public List<GamesDetails> getAllDetails();
}
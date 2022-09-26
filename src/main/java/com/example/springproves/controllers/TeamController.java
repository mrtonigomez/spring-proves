package com.example.springproves.controllers;

import com.example.springproves.models.massiv_db.Team;
import com.example.springproves.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TeamController {

    @Autowired
    TeamService teamService;

    @GetMapping("/team")
    public List<Team> getTeams() {
        return teamService.getTeams();
    }

    @PostMapping("/team")
    public Team createTeam(@RequestBody Team team) {
        return teamService.createTeam(team);
    }

}

package com.example.springproves.models;

import javax.persistence.*;

@Entity
@Table(name = "games_csv")
public class Games {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GAME_ID")
    private Integer gameId;

    @Column(name = "GAME_DATE_EST", length = 50)
    private String gameDateEst;

    @Column(name = "GAME_STATUS_TEXT", length = 50)
    private String gameStatusText;

    @Column(name = "HOME_TEAM_ID")
    private Integer homeTeamId;

    @Column(name = "VISITOR_TEAM_ID")
    private Integer visitorTeamId;

    @Column(name = "SEASON")
    private Integer season;

    @Column(name = "TEAM_ID_home")
    private Integer teamIdHome;

    @Column(name = "PTS_home")
    private Integer ptsHome;

    @Column(name = "FG_PCT_home")
    private Double fgPctHome;

    @Column(name = "FT_PCT_home")
    private Double ftPctHome;

    @Column(name = "FG3_PCT_home")
    private Double fg3PctHome;

    @Column(name = "AST_home")
    private Integer astHome;

    @Column(name = "REB_home")
    private Integer rebHome;

    @Column(name = "TEAM_ID_away")
    private Integer teamIdAway;

    @Column(name = "PTS_away")
    private Integer ptsAway;

    @Column(name = "FG_PCT_away")
    private Double fgPctAway;

    @Column(name = "FT_PCT_away")
    private Double ftPctAway;

    @Column(name = "FG3_PCT_away")
    private Double fg3PctAway;

    @Column(name = "AST_away")
    private Integer astAway;

    @Column(name = "REB_away")
    private Integer rebAway;

    @Column(name = "HOME_TEAM_WINS")
    private Integer homeTeamWins;

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public String getGameDateEst() {
        return gameDateEst;
    }

    public void setGameDateEst(String gameDateEst) {
        this.gameDateEst = gameDateEst;
    }

    public String getGameStatusText() {
        return gameStatusText;
    }

    public void setGameStatusText(String gameStatusText) {
        this.gameStatusText = gameStatusText;
    }

    public Integer getHomeTeamId() {
        return homeTeamId;
    }

    public void setHomeTeamId(Integer homeTeamId) {
        this.homeTeamId = homeTeamId;
    }

    public Integer getVisitorTeamId() {
        return visitorTeamId;
    }

    public void setVisitorTeamId(Integer visitorTeamId) {
        this.visitorTeamId = visitorTeamId;
    }

    public Integer getSeason() {
        return season;
    }

    public void setSeason(Integer season) {
        this.season = season;
    }

    public Integer getTeamIdHome() {
        return teamIdHome;
    }

    public void setTeamIdHome(Integer teamIdHome) {
        this.teamIdHome = teamIdHome;
    }

    public Integer getPtsHome() {
        return ptsHome;
    }

    public void setPtsHome(Integer ptsHome) {
        this.ptsHome = ptsHome;
    }

    public Double getFgPctHome() {
        return fgPctHome;
    }

    public void setFgPctHome(Double fgPctHome) {
        this.fgPctHome = fgPctHome;
    }

    public Double getFtPctHome() {
        return ftPctHome;
    }

    public void setFtPctHome(Double ftPctHome) {
        this.ftPctHome = ftPctHome;
    }

    public Double getFg3PctHome() {
        return fg3PctHome;
    }

    public void setFg3PctHome(Double fg3PctHome) {
        this.fg3PctHome = fg3PctHome;
    }

    public Integer getAstHome() {
        return astHome;
    }

    public void setAstHome(Integer astHome) {
        this.astHome = astHome;
    }

    public Integer getRebHome() {
        return rebHome;
    }

    public void setRebHome(Integer rebHome) {
        this.rebHome = rebHome;
    }

    public Integer getTeamIdAway() {
        return teamIdAway;
    }

    public void setTeamIdAway(Integer teamIdAway) {
        this.teamIdAway = teamIdAway;
    }

    public Integer getPtsAway() {
        return ptsAway;
    }

    public void setPtsAway(Integer ptsAway) {
        this.ptsAway = ptsAway;
    }

    public Double getFgPctAway() {
        return fgPctAway;
    }

    public void setFgPctAway(Double fgPctAway) {
        this.fgPctAway = fgPctAway;
    }

    public Double getFtPctAway() {
        return ftPctAway;
    }

    public void setFtPctAway(Double ftPctAway) {
        this.ftPctAway = ftPctAway;
    }

    public Double getFg3PctAway() {
        return fg3PctAway;
    }

    public void setFg3PctAway(Double fg3PctAway) {
        this.fg3PctAway = fg3PctAway;
    }

    public Integer getAstAway() {
        return astAway;
    }

    public void setAstAway(Integer astAway) {
        this.astAway = astAway;
    }

    public Integer getRebAway() {
        return rebAway;
    }

    public void setRebAway(Integer rebAway) {
        this.rebAway = rebAway;
    }

    public Integer getHomeTeamWins() {
        return homeTeamWins;
    }

    public void setHomeTeamWins(Integer homeTeamWins) {
        this.homeTeamWins = homeTeamWins;
    }

}
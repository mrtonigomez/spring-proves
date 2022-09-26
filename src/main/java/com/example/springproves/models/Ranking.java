package com.example.springproves.models;

import javax.persistence.*;

@Entity
@Table(name = "ranking_csv")
public class Ranking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STANDINGSDATE", length = 50)
    private String standingsdate;

    @Column(name = "TEAM_ID")
    private Integer teamId;

    @Column(name = "LEAGUE_ID")
    private Integer leagueId;

    @Column(name = "SEASON_ID")
    private Integer seasonId;

    @Column(name = "CONFERENCE", length = 50)
    private String conference;

    @Column(name = "TEAM", length = 50)
    private String team;

    @Column(name = "G")
    private Integer g;

    @Column(name = "W")
    private Integer w;

    @Column(name = "L")
    private Integer l;

    @Column(name = "W_PCT")
    private Double wPct;

    @Column(name = "HOME_RECORD", length = 50)
    private String homeRecord;

    @Column(name = "ROAD_RECORD", length = 50)
    private String roadRecord;

    @Column(name = "RETURNTOPLAY", length = 50)
    private String returntoplay;

    public String getStandingsdate() {
        return standingsdate;
    }

    public void setStandingsdate(String standingsdate) {
        this.standingsdate = standingsdate;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public Integer getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(Integer leagueId) {
        this.leagueId = leagueId;
    }

    public Integer getSeasonId() {
        return seasonId;
    }

    public void setSeasonId(Integer seasonId) {
        this.seasonId = seasonId;
    }

    public String getConference() {
        return conference;
    }

    public void setConference(String conference) {
        this.conference = conference;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public Integer getG() {
        return g;
    }

    public void setG(Integer g) {
        this.g = g;
    }

    public Integer getW() {
        return w;
    }

    public void setW(Integer w) {
        this.w = w;
    }

    public Integer getL() {
        return l;
    }

    public void setL(Integer l) {
        this.l = l;
    }

    public Double getWPct() {
        return wPct;
    }

    public void setWPct(Double wPct) {
        this.wPct = wPct;
    }

    public String getHomeRecord() {
        return homeRecord;
    }

    public void setHomeRecord(String homeRecord) {
        this.homeRecord = homeRecord;
    }

    public String getRoadRecord() {
        return roadRecord;
    }

    public void setRoadRecord(String roadRecord) {
        this.roadRecord = roadRecord;
    }

    public String getReturntoplay() {
        return returntoplay;
    }

    public void setReturntoplay(String returntoplay) {
        this.returntoplay = returntoplay;
    }

}
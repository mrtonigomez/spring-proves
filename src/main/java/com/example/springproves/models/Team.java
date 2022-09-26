
package com.example.springproves.models;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "teams_csv")
public class Team {


    @Column(name = "LEAGUE_ID")
    private Integer leagueId;

    @Id
    @Column(name = "TEAM_ID")
    private Integer teamId;

    @Column(name = "MIN_YEAR")
    private Integer minYear;

    @Column(name = "MAX_YEAR")
    private Integer maxYear;

    @Column(name = "ABBREVIATION", length = 50)
    private String abbreviation;

    @Column(name = "NICKNAME", length = 50)
    private String nickname;

    @Column(name = "YEARFOUNDED")
    private Integer yearfounded;

    @Column(name = "CITY", length = 50)
    private String city;

    @Column(name = "ARENA", length = 50)
    private String arena;

    @Column(name = "ARENACAPACITY")
    private Integer arenacapacity;

    @Column(name = "OWNER", length = 50)
    private String owner;

    @Column(name = "GENERALMANAGER", length = 50)
    private String generalmanager;

    @Column(name = "HEADCOACH", length = 50)
    private String headcoach;

    @Column(name = "DLEAGUEAFFILIATION", length = 50)
    private String dleagueaffiliation;

    public String getDleagueaffiliation() {
        return dleagueaffiliation;
    }

    public void setDleagueaffiliation(String dleagueaffiliation) {
        this.dleagueaffiliation = dleagueaffiliation;
    }

    public String getHeadcoach() {
        return headcoach;
    }

    public void setHeadcoach(String headcoach) {
        this.headcoach = headcoach;
    }

    public String getGeneralmanager() {
        return generalmanager;
    }

    public void setGeneralmanager(String generalmanager) {
        this.generalmanager = generalmanager;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Integer getArenacapacity() {
        return arenacapacity;
    }

    public void setArenacapacity(Integer arenacapacity) {
        this.arenacapacity = arenacapacity;
    }

    public String getArena() {
        return arena;
    }

    public void setArena(String arena) {
        this.arena = arena;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getYearfounded() {
        return yearfounded;
    }

    public void setYearfounded(Integer yearfounded) {
        this.yearfounded = yearfounded;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public Integer getMaxYear() {
        return maxYear;
    }

    public void setMaxYear(Integer maxYear) {
        this.maxYear = maxYear;
    }

    public Integer getMinYear() {
        return minYear;
    }

    public void setMinYear(Integer minYear) {
        this.minYear = minYear;
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
}


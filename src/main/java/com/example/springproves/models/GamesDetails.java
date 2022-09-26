package com.example.springproves.models;

import javax.persistence.*;

@Entity
@Table(name = "games_details_csv")
public class GamesDetails {

    @ManyToOne
    @JoinColumn(name = "GAME_ID", referencedColumnName = "GAME_ID")
    private Games gameId;

    @Id
    @Column(name = "TEAM_ID")
    private Integer teamId;

    @Column(name = "TEAM_ABBREVIATION", length = 50)
    private String teamAbbreviation;

    @Column(name = "TEAM_CITY", length = 50)
    private String teamCity;

    @Column(name = "PLAYER_ID")
    private Integer playerId;

    @Column(name = "PLAYER_NAME", length = 50)
    private String playerName;

    @Column(name = "NICKNAME", length = 50)
    private String nickname;

    @Column(name = "START_POSITION", length = 50)
    private String startPosition;

    @Column(name = "COMMENT", length = 50)
    private String comment;

    @Column(name = "MIN", length = 50)
    private String min;

    @Column(name = "FGM")
    private Double fgm;

    @Column(name = "FGA")
    private Double fga;

    @Column(name = "FG_PCT")
    private Double fgPct;

    @Column(name = "FG3M")
    private Double fg3m;

    @Column(name = "FG3A")
    private Double fg3a;

    @Column(name = "FG3_PCT")
    private Double fg3Pct;

    @Column(name = "FTM")
    private Double ftm;

    @Column(name = "FTA")
    private Double fta;

    @Column(name = "FT_PCT")
    private Double ftPct;

    @Column(name = "OREB")
    private Double oreb;

    @Column(name = "DREB")
    private Double dreb;

    @Column(name = "REB")
    private Double reb;

    @Column(name = "AST")
    private Double ast;

    @Column(name = "STL")
    private Double stl;

    @Column(name = "BLK")
    private Double blk;

    @Column(name = "`TO`")
    private Double to;

    @Column(name = "PF")
    private Double pf;

    @Column(name = "PTS")
    private Double pts;

    @Column(name = "PLUS_MINUS")
    private Double plusMinus;

    public Double getPlusMinus() {
        return plusMinus;
    }

    public void setPlusMinus(Double plusMinus) {
        this.plusMinus = plusMinus;
    }

    public Double getPts() {
        return pts;
    }

    public void setPts(Double pts) {
        this.pts = pts;
    }

    public Double getPf() {
        return pf;
    }

    public void setPf(Double pf) {
        this.pf = pf;
    }

    public Double getTo() {
        return to;
    }

    public void setTo(Double to) {
        this.to = to;
    }

    public Double getBlk() {
        return blk;
    }

    public void setBlk(Double blk) {
        this.blk = blk;
    }

    public Double getStl() {
        return stl;
    }

    public void setStl(Double stl) {
        this.stl = stl;
    }

    public Double getAst() {
        return ast;
    }

    public void setAst(Double ast) {
        this.ast = ast;
    }

    public Double getReb() {
        return reb;
    }

    public void setReb(Double reb) {
        this.reb = reb;
    }

    public Double getDreb() {
        return dreb;
    }

    public void setDreb(Double dreb) {
        this.dreb = dreb;
    }

    public Double getOreb() {
        return oreb;
    }

    public void setOreb(Double oreb) {
        this.oreb = oreb;
    }

    public Double getFtPct() {
        return ftPct;
    }

    public void setFtPct(Double ftPct) {
        this.ftPct = ftPct;
    }

    public Double getFta() {
        return fta;
    }

    public void setFta(Double fta) {
        this.fta = fta;
    }

    public Double getFtm() {
        return ftm;
    }

    public void setFtm(Double ftm) {
        this.ftm = ftm;
    }

    public Double getFg3Pct() {
        return fg3Pct;
    }

    public void setFg3Pct(Double fg3Pct) {
        this.fg3Pct = fg3Pct;
    }

    public Double getFg3a() {
        return fg3a;
    }

    public void setFg3a(Double fg3a) {
        this.fg3a = fg3a;
    }

    public Double getFg3m() {
        return fg3m;
    }

    public void setFg3m(Double fg3m) {
        this.fg3m = fg3m;
    }

    public Double getFgPct() {
        return fgPct;
    }

    public void setFgPct(Double fgPct) {
        this.fgPct = fgPct;
    }

    public Double getFga() {
        return fga;
    }

    public void setFga(Double fga) {
        this.fga = fga;
    }

    public Double getFgm() {
        return fgm;
    }

    public void setFgm(Double fgm) {
        this.fgm = fgm;
    }

    public String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getStartPosition() {
        return startPosition;
    }

    public void setStartPosition(String startPosition) {
        this.startPosition = startPosition;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    public String getTeamCity() {
        return teamCity;
    }

    public void setTeamCity(String teamCity) {
        this.teamCity = teamCity;
    }

    public String getTeamAbbreviation() {
        return teamAbbreviation;
    }

    public void setTeamAbbreviation(String teamAbbreviation) {
        this.teamAbbreviation = teamAbbreviation;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public Games getGameId() {
        return gameId;
    }

    public void setGameId(Games gameId) {
        this.gameId = gameId;
    }
}

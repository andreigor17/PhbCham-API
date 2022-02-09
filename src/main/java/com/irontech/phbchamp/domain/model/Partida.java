package com.irontech.phbchamp.domain.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import com.irontech.phbchamp.enums.Maps;
import com.irontech.phbchamp.generic.ModeloGenerico;

@Entity
public class Partida extends ModeloGenerico implements Serializable{
	
    @ManyToOne
    private Team team1;
    @ManyToOne
    private Team team2;
    
    private int scoreT1;
    
    private int scoreT2;
    
    @Enumerated(EnumType.STRING)
    private Maps mapas;

    public Partida() {
    }
    
    public Team getTeam1() {
        return team1;
    }

    public void setTeam1(Team team1) {
        this.team1 = team1;
    }

    public Team getTeam2() {
        return team2;
    }

    public void setTeam2(Team team2) {
        this.team2 = team2;
    }

    public int getScoreT1() {
        return scoreT1;
    }

    public void setScoreT1(int scoreT1) {
        this.scoreT1 = scoreT1;
    }

    public int getScoreT2() {
        return scoreT2;
    }

    public void setScoreT2(int scoreT2) {
        this.scoreT2 = scoreT2;
    }

    public Partida(Team team1, Team team2) {
        this.team1 = team1;
        this.team2 = team2;
        
    }
    

}

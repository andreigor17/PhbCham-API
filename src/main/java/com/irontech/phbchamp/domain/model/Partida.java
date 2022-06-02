package com.irontech.phbchamp.domain.model;

import java.io.Serializable;

import javax.persistence.Entity;
import com.irontech.phbchamp.generic.ModeloGenerico;
import java.util.List;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Partida extends ModeloGenerico implements Serializable {

    @ManyToOne
    private Team team1;
    
    @ManyToOne
    private Team team2;

    @ManyToOne
    private Campeonato camp;

    private int scoreT1;

    private int scoreT2;

    @Enumerated(EnumType.STRING)
    private Maps mapas;
    
    @OneToMany
    private List<ItemPartida> itemPartida;

    public Partida() {
    }

    public List<ItemPartida> getItemPartida() {
        return itemPartida;
    }

    public void setItemPartida(List<ItemPartida> itemPartida) {
        this.itemPartida = itemPartida;
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

<<<<<<< HEAD
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

    public Campeonato getCamp() {
        return camp;
    }

    public void setCamp(Campeonato camp) {
        this.camp = camp;
    }

    public Maps getMapas() {
        return mapas;
    }

    public void setMapas(Maps mapas) {
        this.mapas = mapas;
    }
    
}

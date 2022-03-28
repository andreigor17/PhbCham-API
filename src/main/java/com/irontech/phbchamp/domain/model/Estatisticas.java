package com.irontech.phbchamp.domain.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.irontech.phbchamp.generic.ModeloGenerico;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Estatisticas extends ModeloGenerico implements Serializable {
	
	@Column(columnDefinition = "integer default 0")
    private Integer kills = 0;
    @Column(columnDefinition = "integer default 0")
    private Integer deaths = 0;
    @Column(columnDefinition = "integer default 0")
    private Integer assists = 0;
    @Column(columnDefinition = "integer default 0")
    private Integer roundsGanhos = 0;
    @Column(columnDefinition = "integer default 0")
    private Integer roundsPerdidos = 0;
    @Column(columnDefinition = "integer default 0")
    private Integer partidas = 0;
    @Column(columnDefinition = "integer default 0")
    private Integer pontos = 0;
    @ManyToOne
    private Team team;
    @ManyToOne
    private Campeonato campeonato;

    public Integer getKills() {
        return kills;
    }

    public void setKills(Integer kills) {
        this.kills = kills;
    }

    public Integer getDeaths() {
        return deaths;
    }

    public void setDeaths(Integer deaths) {
        this.deaths = deaths;
    }

    public Integer getAssists() {
        return assists;
    }

    public void setAssists(Integer assists) {
        this.assists = assists;
    }

    public Integer getRoundsGanhos() {
        return roundsGanhos;
    }

    public void setRoundsGanhos(Integer roundsGanhos) {
        this.roundsGanhos = roundsGanhos;
    }

    public Integer getRoundsPerdidos() {
        return roundsPerdidos;
    }

    public void setRoundsPerdidos(Integer roundsPerdidos) {
        this.roundsPerdidos = roundsPerdidos;
    }

    public Integer getPartidas() {
        return partidas;
    }

    public void setPartidas(Integer partidas) {
        this.partidas = partidas;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Campeonato getCampeonato() {
        return campeonato;
    }

    public void setCampeonato(Campeonato campeonato) {
        this.campeonato = campeonato;
    }

    public Integer getPontos() {
        return pontos;
    }

    public void setPontos(Integer pontos) {
        this.pontos = pontos;
    }

}

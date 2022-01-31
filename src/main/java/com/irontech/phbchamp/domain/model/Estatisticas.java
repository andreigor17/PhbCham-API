package com.irontech.phbchamp.domain.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.irontech.phbchamp.generic.ModeloGenerico;

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
    private Long team_id;
    private Long campeonato_id;

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

    public Long getTeam_id() {
        return team_id;
    }

    public void setTeam_id(Long team_id) {
        this.team_id = team_id;
    }


    public Long getCampeonato_id() {
        return campeonato_id;
    }

    public void setCampeonato_id(Long campeonato_id) {
        this.campeonato_id = campeonato_id;
    }

    public Integer getPontos() {
        return pontos;
    }

    public void setPontos(Integer pontos) {
        this.pontos = pontos;
    }

}
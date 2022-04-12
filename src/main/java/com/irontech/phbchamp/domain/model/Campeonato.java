package com.irontech.phbchamp.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.irontech.phbchamp.enums.StatusCamp;
import com.irontech.phbchamp.generic.ModeloGenerico;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Temporal;

@Entity
public class Campeonato extends ModeloGenerico implements Serializable {

    private String nome;
    @ManyToMany
    private List<Team> teams;
    @Enumerated(EnumType.STRING)
    private StatusCamp status;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Partida> partidas;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Estatisticas> estatisticas;
    @Column(name = "data_camp")
    @JsonFormat(pattern = "dd/MM/yyyy")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataCamp;
    @Column(name = "data_string")
    private String dataString;

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public StatusCamp getStatus() {
        return status;
    }

    public void setStatus(StatusCamp status) {
        this.status = status;
    }

    public List<Partida> getPartidas() {
        return partidas;
    }

    public void setPartidas(List<Partida> partidas) {
        this.partidas = partidas;
    }

    public List<Estatisticas> getEstatisticas() {
        return estatisticas;
    }

    public void setEstatisticas(List<Estatisticas> estatisticas) {
        this.estatisticas = estatisticas;
    }

    public Date getDataCamp() {
        return dataCamp;
    }

    public void setDataCamp(Date dataCamp) {
        this.dataCamp = dataCamp;
    }

    public String getDataString() {
        return dataString;
    }

    public void setDataString(String dataString) {
        this.dataString = dataString;
    }

    @Override
    public String toString() {

        return "Nome" + nome + "id" + id;
    }

}

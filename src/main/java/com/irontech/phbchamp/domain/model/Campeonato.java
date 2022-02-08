package com.irontech.phbchamp.domain.model;

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

@Entity
public class Campeonato extends ModeloGenerico implements Serializable {
	
	
    private String nome;
    @ManyToMany
    private List<Team> teams;
    @Enumerated(EnumType.STRING)
    private StatusCamp status;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Partida> partidas;
    
    
	
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
    
    

}

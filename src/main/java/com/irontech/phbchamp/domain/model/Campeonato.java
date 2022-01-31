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
	
	@ManyToMany
    private List<Team> Teams;
    @ManyToMany
    private List<Player> players;
    private String nome;
    @Enumerated(EnumType.STRING)
    private StatusCamp status;
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Partida> partidas;
    
    
	public List<Team> getTeams() {
		return Teams;
	}
	public void setTeams(List<Team> teams) {
		Teams = teams;
	}
	public List<Player> getPlayers() {
		return players;
	}
	public void setPlayers(List<Player> players) {
		this.players = players;
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

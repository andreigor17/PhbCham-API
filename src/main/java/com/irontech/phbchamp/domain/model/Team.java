package com.irontech.phbchamp.domain.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.irontech.phbchamp.generic.ModeloGenerico;

@Entity
public class Team extends ModeloGenerico implements Serializable {
	
	private String nome;
    @ManyToMany
    private List<Player> players;
    @OneToMany
    private List<Estatisticas> estatisticas;
    

    public String getNome() {
        return nome;
    }
    

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
    

    public List<Estatisticas> getEstatisticas() {
        return estatisticas;
    }

    public void setEstatisticas(List<Estatisticas> estatisticas) {
        this.estatisticas = estatisticas;
    }

}

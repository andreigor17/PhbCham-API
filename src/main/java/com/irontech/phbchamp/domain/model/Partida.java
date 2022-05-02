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

}

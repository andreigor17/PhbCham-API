package com.irontech.phbchamp.domain.model;

import java.io.Serializable;

import javax.persistence.Entity;
import com.irontech.phbchamp.generic.ModeloGenerico;
import java.util.List;
import javax.persistence.OneToMany;

@Entity
public class Partida extends ModeloGenerico implements Serializable {

    
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
    
}

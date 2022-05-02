/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.irontech.phbchamp.domain.model;

import com.irontech.phbchamp.enums.Maps;
import com.irontech.phbchamp.generic.ModeloGenerico;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

/**
 *
 * @author andre
 */
@Entity
public class ItemPartida extends ModeloGenerico implements Serializable {

    private int scoreT1;

    private int scoreT2;

    @Enumerated(EnumType.STRING)
    private Maps mapas;
    @ManyToOne
    private Partida partida;

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

    public Maps getMapas() {
        return mapas;
    }

    public void setMapas(Maps mapas) {
        this.mapas = mapas;
    }

    public Partida getPartida() {
        return partida;
    }

    public void setPartida(Partida partida) {
        this.partida = partida;
    }
    
    

}

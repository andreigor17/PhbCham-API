/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.irontech.phbchamp.domain.model;

import com.irontech.phbchamp.enums.TipoPickBan;
import com.irontech.phbchamp.generic.ModeloGenerico;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 *
 * @author andreigor
 */
@Entity
public class PickBan extends ModeloGenerico implements Serializable {

    @OneToMany
    List<Mapas> pickedMapa;
    @OneToMany
    List<Mapas> remainingMapa;

    public List<Mapas> getPickedMapa() {
        return pickedMapa;
    }

    public void setPickedMapa(List<Mapas> pickedMapa) {
        this.pickedMapa = pickedMapa;
    }

    public List<Mapas> getRemainingMapa() {
        return remainingMapa;
    }

    public void setRemainingMapa(List<Mapas> remainingMapa) {
        this.remainingMapa = remainingMapa;
    }

}

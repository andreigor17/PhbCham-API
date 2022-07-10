/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.irontech.phbchamp.domain.model;

import com.irontech.phbchamp.generic.ModeloGenerico;
import java.io.Serializable;
import javax.persistence.Entity;

/**
 *
 * @author andre
 */
@Entity
public class Jogo extends ModeloGenerico implements Serializable{
    
    private String nome;
    
    public Jogo(){
        
    }

    public Jogo(String nome) {
        this.nome = nome;
    }        

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
           
    
}

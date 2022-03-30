/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.irontech.phbchamp.domain.model;

import com.irontech.phbchamp.generic.ModeloGenerico;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;

/**
 *
 * @author andre
 */
@Entity
public class Configuracao extends ModeloGenerico implements Serializable{
    
    @Column(name = "caminho_api")
    private String caminhoApi;

    public String getCaminhoApi() {
        return caminhoApi;
    }

    public void setCaminhoApi(String caminhoApi) {
        this.caminhoApi = caminhoApi;
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.irontech.phbchamp.domain.repository;

import com.irontech.phbchamp.domain.model.Mapas;
import java.util.List;

/**
 *
 * @author andre
 */
public interface MapaRepository {

    List<Mapas> listar();

    Mapas buscar(Long id);

    Mapas salvar(Mapas mapas);

    void remover(Long id);

}

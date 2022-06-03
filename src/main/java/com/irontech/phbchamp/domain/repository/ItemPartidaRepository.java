/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.irontech.phbchamp.domain.repository;

import com.irontech.phbchamp.domain.model.ItemPartida;
import java.util.List;

/**
 *
 * @author andre
 */
public interface ItemPartidaRepository {

    List<ItemPartida> listar();

    ItemPartida buscar(Long id);

    ItemPartida salvar(ItemPartida itemPartida);

    void remover(Long id);

}

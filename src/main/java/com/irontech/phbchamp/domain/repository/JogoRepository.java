/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.irontech.phbchamp.domain.repository;

import com.irontech.phbchamp.domain.model.Jogo;
import java.util.List;

/**
 *
 * @author andre
 */
public interface JogoRepository {

    List<Jogo> listar();

    Jogo buscar(Long id);

    Jogo salvar(Jogo jogo);

    void remover(Long id);

}

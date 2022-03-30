/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.irontech.phbchamp.domain.repository;

import com.irontech.phbchamp.domain.model.Configuracao;
import java.util.List;

/**
 *
 * @author andre
 */
public interface ConfiguracaoRepository {

    List<Configuracao> listar();

    Configuracao buscar(Long id);

    Configuracao salvar(Configuracao config);

    void remover(Long id);

}

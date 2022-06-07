/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.irontech.phbchamp.domain.service;

import com.irontech.phbchamp.domain.exception.EntidadeEmUsoException;
import com.irontech.phbchamp.domain.exception.EntidadeNaoEncontradaException;
import com.irontech.phbchamp.domain.model.Mapas;
import com.irontech.phbchamp.domain.repository.MapaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

/**
 *
 * @author andre
 */
@Service
public class MapaService {

    @Autowired
    private MapaRepository mapaRepository;

    public Mapas salvar(Mapas mapa) {
        return mapaRepository.salvar(mapa);
    }

    public void excluir(Long playerId) {
        try {
            mapaRepository.remover(playerId);
        } catch (EmptyResultDataAccessException e) {
            throw new EntidadeNaoEncontradaException("Mapa não encontrado!");
        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException("Mapa não pode ser removido!");
        }
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.irontech.phbchamp.domain.service;

import com.irontech.phbchamp.domain.exception.EntidadeEmUsoException;
import com.irontech.phbchamp.domain.exception.EntidadeNaoEncontradaException;
import com.irontech.phbchamp.domain.model.ItemPartida;
import com.irontech.phbchamp.domain.repository.ItemPartidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

/**
 *
 * @author andre
 */
@Service
public class ItemPartidaServico {
    
    @Autowired
	private ItemPartidaRepository itemPartidaRepositiry;
    
    public ItemPartida salvar(ItemPartida itemPartida) {
		return itemPartidaRepositiry.salvar(itemPartida);
	}
    
    public void excluir(Long partidaId) {
		try {
			itemPartidaRepositiry.remover(partidaId);
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException("ItemPartida não encontrada!");
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException("item não pode ser removida pois esta em uma partida");
		}
	}
    
}

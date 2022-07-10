/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.irontech.phbchamp.domain.service;

import com.irontech.phbchamp.domain.exception.EntidadeEmUsoException;
import com.irontech.phbchamp.domain.exception.EntidadeNaoEncontradaException;
import com.irontech.phbchamp.domain.model.Jogo;
import com.irontech.phbchamp.domain.repository.JogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

/**
 *
 * @author andre
 */
@Service
public class CadastroJogoService {

    @Autowired
    private JogoRepository jogoRepository;

    public Jogo salvar(Jogo jogo) {
        return jogoRepository.salvar(jogo);
    }

    public void excluir(Long playerId) {
        try {
            jogoRepository.remover(playerId);
        } catch (EmptyResultDataAccessException e) {
            throw new EntidadeNaoEncontradaException("Jogo não encontrado!");
        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException("Jogo não pode ser removido pois esta em uso por um player");
        }
    }

}

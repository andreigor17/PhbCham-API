/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.irontech.phbchamp.domain.service;

import com.irontech.phbchamp.domain.exception.EntidadeEmUsoException;
import com.irontech.phbchamp.domain.exception.EntidadeNaoEncontradaException;
import com.irontech.phbchamp.domain.model.PickBan;
import com.irontech.phbchamp.domain.repository.PickBanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

/**
 *
 * @author andreigor
 */
@Service
public class PickBanService {

    @Autowired
    private PickBanRepository pickBanRepository;

    public PickBan salvar(PickBan pb) {
        return pickBanRepository.salvar(pb);
    }

    public void excluir(Long playerId) {
        try {
            pickBanRepository.remover(playerId);
        } catch (EmptyResultDataAccessException e) {
            throw new EntidadeNaoEncontradaException("Mapa não encontrado!");
        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException("Mapa não pode ser removido!");
        }
    }

}

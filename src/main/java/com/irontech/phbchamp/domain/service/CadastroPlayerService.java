package com.irontech.phbchamp.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.irontech.phbchamp.domain.exception.EntidadeEmUsoException;
import com.irontech.phbchamp.domain.exception.EntidadeNaoEncontradaException;
import com.irontech.phbchamp.domain.model.Player;
import com.irontech.phbchamp.domain.repository.PlayerRepository;

@Service
public class CadastroPlayerService {

	@Autowired
	private PlayerRepository playerRepository;

	public Player salvar(Player player) {
		return playerRepository.salvar(player);
	}

	public void excluir(Long playerId) {
		try {
			playerRepository.remover(playerId);
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException("Player não encontrado!");
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException("Player não pode ser removido pois esta em uso por um time");
		}
	}

}

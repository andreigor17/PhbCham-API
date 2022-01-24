package com.irontech.phbchamp.domain.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.irontech.phbchamp.domain.exception.EntidadeEmUsoException;
import com.irontech.phbchamp.domain.exception.EntidadeNaoEncontradaException;
import com.irontech.phbchamp.domain.model.Player;
import com.irontech.phbchamp.domain.model.Team;
import com.irontech.phbchamp.domain.repository.PlayerRepository;
import com.irontech.phbchamp.domain.repository.TeamRepository;

@Service
public class CadastroTeamService {

	@Autowired
	private TeamRepository teamRepository;
	@Autowired
	private PlayerRepository playerRepository;

	public Team salvar(Team team) {
		List<Player> players = new ArrayList<>();
		for (Player p : team.getPlayers()) {
			Long playerId = p.getId();
			Player player = playerRepository.buscar(playerId);

			if (player == null) {
				throw new EntidadeNaoEncontradaException(
						String.format("Não existe player com o id %d cadastrada!", playerId));
			}
			players.add(player);
		}		
		team.setPlayers(players);
		return teamRepository.salvar(team);
	}

	public void excluir(Long teamId) {
		try {
			teamRepository.remover(teamId);
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException("Time não encontrado!");
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException("Time não pode ser removido!");
		}
	}

}

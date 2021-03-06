package com.irontech.phbchamp.domain.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.irontech.phbchamp.domain.exception.EntidadeEmUsoException;
import com.irontech.phbchamp.domain.exception.EntidadeNaoEncontradaException;
import com.irontech.phbchamp.domain.model.Campeonato;
import com.irontech.phbchamp.domain.model.Player;
import com.irontech.phbchamp.domain.model.Team;
import com.irontech.phbchamp.domain.repository.CampeonatoRepository;
import com.irontech.phbchamp.domain.repository.PlayerRepository;
import com.irontech.phbchamp.domain.repository.TeamRepository;

@Service
public class CadastroCampService {

	@Autowired
	private CampeonatoRepository campeonatoRepository;
	@Autowired
	private PlayerRepository playerRepository;
	@Autowired
	private TeamRepository teamRepository;

	public Campeonato salvar(Campeonato campeonato) {
		List<Team> teams = new ArrayList<>();

		for (Team t : campeonato.getTeams()) {
			Long teamId = t.getId();
			Team team = teamRepository.buscar(teamId);
			if (team == null) {
				throw new EntidadeNaoEncontradaException(
						String.format("Não existe time com o id %d cadastrado!", teamId));
			}
			teams.add(team);
		}

		campeonato.setTeams(teams);
		return campeonatoRepository.salvar(campeonato);

	}

	public void excluir(Long campId) {
		try {
			campeonatoRepository.remover(campId);
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException("Campeonato não encontrado!");
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException("Campeonato não pode ser removido!");
		}
	}

}

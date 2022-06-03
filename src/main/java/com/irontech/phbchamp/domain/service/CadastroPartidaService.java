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
import com.irontech.phbchamp.domain.model.Partida;
import com.irontech.phbchamp.domain.repository.CampeonatoRepository;
import com.irontech.phbchamp.domain.repository.PartidaRepository;

@Service
public class CadastroPartidaService {

	@Autowired
	private PartidaRepository partidaRepository;
	@Autowired
	private CampeonatoRepository campeonatoRepository;

	public Partida salvar(Partida partida) {
		return partidaRepository.salvar(partida);
	}

	public void excluir(Long partidaId) {
		try {
			partidaRepository.remover(partidaId);
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException("Partida não encontrada!");
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException("Partida não pode ser removida pois esta em andamento");
		}
	}

	public List<Partida> partidasPorCamp(String campId) {
		Campeonato camp = new Campeonato();
		if (campId != null) {
			camp = campeonatoRepository.buscar(Long.parseLong(campId));
		}

		if (camp != null) {
			List<Partida> p = new ArrayList<>();
			p = camp.getPartidas();
			return p;
		}

		return null;

	}

}

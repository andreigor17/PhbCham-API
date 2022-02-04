package com.irontech.phbchamp.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.irontech.phbchamp.domain.exception.EntidadeEmUsoException;
import com.irontech.phbchamp.domain.exception.EntidadeNaoEncontradaException;
import com.irontech.phbchamp.domain.model.Estatisticas;
import com.irontech.phbchamp.domain.repository.CampeonatoRepository;
import com.irontech.phbchamp.domain.repository.EstatisticasRepository;
import com.irontech.phbchamp.domain.repository.PlayerRepository;
import com.irontech.phbchamp.domain.repository.TeamRepository;

@Service
public class CadastroEstatisticasService {

	@Autowired
	private CampeonatoRepository campeonatoRepository;
	@Autowired
	private PlayerRepository playerRepository;
	@Autowired
	private TeamRepository teamRepository;
	@Autowired
	private EstatisticasRepository estatisticasRepository;

	public Estatisticas salvar(Estatisticas estatisticas) {
		return estatisticasRepository.salvar(estatisticas);
	}

	public void excluir(Long estId) {
		try {
			estatisticasRepository.remover(estId);
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException("Estatistica não encontrada!");
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException("Estatistica não pode ser removida!");
		}
	}

}

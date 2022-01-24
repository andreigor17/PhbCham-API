package com.irontech.phbchamp.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.irontech.phbchamp.domain.exception.EntidadeEmUsoException;
import com.irontech.phbchamp.domain.exception.EntidadeNaoEncontradaException;
import com.irontech.phbchamp.domain.model.Campeonato;
import com.irontech.phbchamp.domain.repository.CampeonatoRepository;

@Service
public class CadastroCampService {
	
	@Autowired
	private CampeonatoRepository campeonatoRepository;

	public Campeonato salvar(Campeonato campeonato) {
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

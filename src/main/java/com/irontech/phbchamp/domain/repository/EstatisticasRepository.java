package com.irontech.phbchamp.domain.repository;

import java.util.List;

import com.irontech.phbchamp.domain.model.Estatisticas;

public interface EstatisticasRepository {

	List<Estatisticas> listar();

	Estatisticas buscar(Long id);

	Estatisticas salvar(Estatisticas estatisticas);

	void remover(Long id);
	
	List<Estatisticas> estatisticaPorTime(Long id, Long id2);

}

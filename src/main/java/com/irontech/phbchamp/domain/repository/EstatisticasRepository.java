package com.irontech.phbchamp.domain.repository;

import com.irontech.phbchamp.domain.model.Campeonato;
import java.util.List;

import com.irontech.phbchamp.domain.model.Estatisticas;
import com.irontech.phbchamp.domain.model.ItemPartida;
import com.irontech.phbchamp.domain.model.Partida;
import com.irontech.phbchamp.domain.model.Team;

public interface EstatisticasRepository {

	List<Estatisticas> listar();

	Estatisticas buscar(Long id);

	Estatisticas salvar(Estatisticas estatisticas);

	void remover(Long id);
	
	List<Estatisticas> estatisticaPorTime(Team team, Campeonato camp);
        
        List<Estatisticas> estatisticaPorItemPartida(Team team, ItemPartida item);
        
        List<Estatisticas> estatisticasGeraisPorItemPartida(Team team, Partida partida);

}

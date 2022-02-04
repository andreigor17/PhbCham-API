package com.irontech.phbchamp.domain.repository;

import java.util.List;

import com.irontech.phbchamp.domain.model.Campeonato;
import com.irontech.phbchamp.domain.model.Partida;

public interface PartidaRepository {

	List<Partida> listar();

	Partida buscar(Long id);

	Partida salvar(Partida partida);

	void remover(Long id);

	List<Partida> partidaPorCamp(Campeonato camp);

}

package com.irontech.phbchamp.domain.repository;

import java.util.List;

import com.irontech.phbchamp.domain.model.Campeonato;

public interface CampeonatoRepository {

	List<Campeonato> listar();

	Campeonato buscar(Long id);

	Campeonato salvar(Campeonato camp);

	void remover(Long id);

}

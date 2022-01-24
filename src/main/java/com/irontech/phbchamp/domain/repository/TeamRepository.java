package com.irontech.phbchamp.domain.repository;

import java.util.List;

import com.irontech.phbchamp.domain.model.Team;

public interface TeamRepository {
	
	List<Team> listar();

	Team buscar(Long id);

	Team salvar(Team team);

	void remover(Long id);

}

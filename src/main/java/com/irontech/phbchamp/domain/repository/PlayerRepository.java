package com.irontech.phbchamp.domain.repository;

import java.util.List;

import com.irontech.phbchamp.domain.model.Player;

public interface PlayerRepository {
	
	List<Player> listar();
	Player buscar(Long id);
	Player salvar(Player player);
	void remover(Long id);

}

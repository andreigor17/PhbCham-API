package com.irontech.phbchamp.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.irontech.phbchamp.domain.model.Player;
import com.irontech.phbchamp.domain.repository.PlayerRepository;

@Component
public class PlayerRepositoryJPA implements PlayerRepository{
	
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Player> listar(){
		TypedQuery<Player> query = manager.createQuery("from Player", Player.class);
		return query.getResultList();
	}
	
	@Override
	public Player buscar(Long id) {
		return manager.find(Player.class, id);
	}
	
	@Override
	@Transactional
	public Player salvar(Player player) {
		return manager.merge(player);
	}

	@Override
	@Transactional
	public void remover(Long id) {
		Player player = buscar(id);
                player.setAtivo(false);
		manager.merge(player);
	}
	

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.irontech.phbchamp.infrastructure.repository;

import com.irontech.phbchamp.domain.model.ItemPartida;
import com.irontech.phbchamp.domain.repository.ItemPartidaRepository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import org.springframework.stereotype.Component;

/**
 *
 * @author andre
 */
@Component
public class ItemPartidaRepositoryJPA implements ItemPartidaRepository{
    
    @PersistenceContext
	private EntityManager manager;

	@Override
	public List<ItemPartida> listar() {
		TypedQuery<ItemPartida> query = manager.createQuery("from ItemPartida", ItemPartida.class);
		return query.getResultList();
	}

	@Override
	public ItemPartida buscar(Long id) {
		return manager.find(ItemPartida.class, id);
	}

	@Override
	@Transactional
	public ItemPartida salvar(ItemPartida ItemPartida) {
		return manager.merge(ItemPartida);
	}

	@Override
	@Transactional
	public void remover(Long id) {
		ItemPartida ItemPartida = buscar(id);
		manager.remove(ItemPartida);
	}
    
}

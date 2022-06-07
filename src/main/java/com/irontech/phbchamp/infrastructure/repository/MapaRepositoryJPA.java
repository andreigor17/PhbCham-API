/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.irontech.phbchamp.infrastructure.repository;

import com.irontech.phbchamp.domain.model.Mapas;
import com.irontech.phbchamp.domain.repository.MapaRepository;
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
public class MapaRepositoryJPA implements MapaRepository{
    
    @PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Mapas> listar(){
		TypedQuery<Mapas> query = manager.createQuery("from Mapas", Mapas.class);
		return query.getResultList();
	}
	
	@Override
	public Mapas buscar(Long id) {
		return manager.find(Mapas.class, id);
	}
	
	@Override
	@Transactional
	public Mapas salvar(Mapas mapas) {
		return manager.merge(mapas);
	}

	@Override
	@Transactional
	public void remover(Long id) {
		Mapas mapas = buscar(id);
		manager.remove(mapas);
	}
    
}

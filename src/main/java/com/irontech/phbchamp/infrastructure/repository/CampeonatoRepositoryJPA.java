package com.irontech.phbchamp.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.irontech.phbchamp.domain.model.Campeonato;
import com.irontech.phbchamp.domain.repository.CampeonatoRepository;

@Component
public class CampeonatoRepositoryJPA implements CampeonatoRepository {
	
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Campeonato> listar(){
		TypedQuery<Campeonato> query = manager.createQuery("from Campeonato", Campeonato.class);
		return query.getResultList();
	}
	
	@Override
	public Campeonato buscar(Long id) {
		return manager.find(Campeonato.class, id);
	}
	
	@Override
	@Transactional
	public Campeonato salvar(Campeonato campeonato) {
		return manager.merge(campeonato);
	}

	@Override
	@Transactional
	public void remover(Long id) {
		Campeonato campeonato = buscar(id);
		manager.remove(campeonato);
	}

}

package com.irontech.phbchamp.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.irontech.phbchamp.domain.model.Campeonato;
import com.irontech.phbchamp.domain.model.Partida;
import com.irontech.phbchamp.domain.repository.PartidaRepository;

@Component
public class PartidaRepositoryJPA implements PartidaRepository {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<Partida> listar() {
		TypedQuery<Partida> query = manager.createQuery("from Partida", Partida.class);
		return query.getResultList();
	}

	@Override
	public Partida buscar(Long id) {
		return manager.find(Partida.class, id);
	}

	@Override
	@Transactional
	public Partida salvar(Partida partida) {
		return manager.merge(partida);
	}

	@Override
	@Transactional
	public void remover(Long id) {
		Partida partida = buscar(id);
		manager.remove(partida);
	}
	

}

package com.irontech.phbchamp.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.irontech.phbchamp.domain.model.Team;
import com.irontech.phbchamp.domain.repository.TeamRepository;

@Component
public class TeamRepositoryJPA implements TeamRepository {
	
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Team> listar(){
		TypedQuery<Team> query = manager.createQuery("from Team", Team.class);
		return query.getResultList();
	}
	
	@Override
	public Team buscar(Long id) {
		return manager.find(Team.class, id);
	}
	
	@Override
	@Transactional
	public Team salvar(Team team) {
		return manager.merge(team);
	}

	@Override
	@Transactional
	public void remover(Long id) {
		Team team = buscar(id);
                team.setAtivo(false);
		manager.merge(team);
	}

}

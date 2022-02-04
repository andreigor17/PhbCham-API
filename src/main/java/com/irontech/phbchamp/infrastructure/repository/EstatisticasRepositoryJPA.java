package com.irontech.phbchamp.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.irontech.phbchamp.domain.model.Estatisticas;
import com.irontech.phbchamp.domain.repository.EstatisticasRepository;

@Component
public class EstatisticasRepositoryJPA implements EstatisticasRepository {
	
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Estatisticas> listar(){
		TypedQuery<Estatisticas> query = manager.createQuery("from Estatisticas", Estatisticas.class);
		return query.getResultList();
	}
	
	@Override
	public Estatisticas buscar(Long id) {
		return manager.find(Estatisticas.class, id);
	}
	
	@Override
	@Transactional
	public Estatisticas salvar(Estatisticas estatisticas) {
		return manager.merge(estatisticas);
	}

	@Override
	@Transactional
	public void remover(Long id) {
		Estatisticas estatisticas = buscar(id);
		manager.remove(estatisticas);
	}
	
	@Override
	public List<Estatisticas> estatisticaPorTime(Long id, Long id2) {
		String sql = "select est from Estatisticas est where ";

        sql += "est.ativo = true";

        if (id != null) {
            sql += " and est.team_id = " + id;
        }

        if (id2 != null) {
            sql += " and est.campeonato_id =" + id2;
        }

        Query query = manager.createQuery(sql);

        return query.getResultList();
	}

}

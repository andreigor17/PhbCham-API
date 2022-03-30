/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.irontech.phbchamp.infrastructure.repository;

import com.irontech.phbchamp.domain.model.Configuracao;
import com.irontech.phbchamp.domain.repository.ConfiguracaoRepository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

/**
 *
 * @author andre
 */
public class ConfiguracaoRepositoryJPA implements ConfiguracaoRepository{
    
    @PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Configuracao> listar(){
		TypedQuery<Configuracao> query = manager.createQuery("from Configuracao", Configuracao.class);
		return query.getResultList();
	}
	
	@Override
	public Configuracao buscar(Long id) {
		return manager.find(Configuracao.class, id);
	}
	
	@Override
	@Transactional
	public Configuracao salvar(Configuracao configuracao) {
		return manager.merge(configuracao);
	}

	@Override
	@Transactional
	public void remover(Long id) {
		Configuracao configuracao = buscar(id);
		manager.remove(configuracao);
	}
    
}

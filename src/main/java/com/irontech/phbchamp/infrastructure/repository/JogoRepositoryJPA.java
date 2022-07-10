/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.irontech.phbchamp.infrastructure.repository;

import com.irontech.phbchamp.domain.model.Jogo;
import com.irontech.phbchamp.domain.repository.JogoRepository;
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
public class JogoRepositoryJPA implements JogoRepository {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Jogo> listar() {
        TypedQuery<Jogo> query = manager.createQuery("from Jogo", Jogo.class);
        return query.getResultList();
    }

    @Override
    public Jogo buscar(Long id) {
        return manager.find(Jogo.class, id);
    }

    @Override
    @Transactional
    public Jogo salvar(Jogo jogo) {
        return manager.merge(jogo);
    }

    @Override
    @Transactional
    public void remover(Long id) {
        Jogo jogo = buscar(id);
        manager.remove(jogo);
    }

}

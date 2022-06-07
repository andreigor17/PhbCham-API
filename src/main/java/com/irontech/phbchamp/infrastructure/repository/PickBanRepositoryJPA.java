/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.irontech.phbchamp.infrastructure.repository;

import com.irontech.phbchamp.domain.model.PickBan;
import com.irontech.phbchamp.domain.repository.PickBanRepository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import org.springframework.stereotype.Component;

/**
 *
 * @author andreigor
 */
@Component
public class PickBanRepositoryJPA implements PickBanRepository {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<PickBan> listar() {
        TypedQuery<PickBan> query = manager.createQuery("from PickBan", PickBan.class);
        return query.getResultList();
    }

    @Override
    public PickBan buscar(Long id) {
        return manager.find(PickBan.class, id);
    }

    @Override
    @Transactional
    public PickBan salvar(PickBan pb) {
        return manager.merge(pb);
    }

    @Override
    @Transactional
    public void remover(Long id) {
        PickBan pb = buscar(id);
        manager.remove(pb);
    }

}

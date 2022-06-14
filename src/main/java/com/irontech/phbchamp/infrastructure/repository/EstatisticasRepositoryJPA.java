package com.irontech.phbchamp.infrastructure.repository;

import com.irontech.phbchamp.domain.model.Campeonato;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.irontech.phbchamp.domain.model.Estatisticas;
import com.irontech.phbchamp.domain.model.ItemPartida;
import com.irontech.phbchamp.domain.model.Partida;
import com.irontech.phbchamp.domain.model.Team;
import com.irontech.phbchamp.domain.repository.EstatisticasRepository;

@Component
public class EstatisticasRepositoryJPA implements EstatisticasRepository {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Estatisticas> listar() {
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
    public List<Estatisticas> estatisticaPorTime(Team team, Campeonato camp) {
        String sql = "select est from Estatisticas est where ";

        sql += "est.ativo = true";

        if (team != null) {
            sql += " and est.team = " + team.getId();
        }

        if (camp != null) {
            sql += " and est.campeonato =" + camp.getId();
        }

        Query query = manager.createQuery(sql);

        return query.getResultList();
    }

    @Override
    public List<Estatisticas> estatisticaPorItemPartida(Team team, ItemPartida item) {
        String sql = "select est from Estatisticas est where ";

        sql += "est.ativo = true";

        if (team != null) {
            sql += " and est.team = " + team.getId();
        }

        if (item != null) {
            sql += " and est.itemPartida =" + item.getId();
        }

        Query query = manager.createQuery(sql);

        return query.getResultList();
    }

    @Override
    public List<Estatisticas> estatisticasGeraisPorItemPartida(Team team, Partida partida) {
        String sql = " select est from Estatisticas est ";
        sql += " join est.itemPartida item";
        sql += " where item.partida = :partida and est.team = :team";

        Query query = manager.createQuery(sql);

        if (partida != null) {
            query.setParameter("partida", partida.getId());

        }

        if (team != null) {
            query.setParameter("team", team);
        }

        return query.getResultList();
    }

}

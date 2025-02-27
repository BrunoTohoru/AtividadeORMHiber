/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atividadelp3.dao;

import com.mycompany.atividadelp3.bean.Estilo;
import com.mycompany.atividadelp3.bean.Filme;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aluno
 */
public class FilmeDao extends DaoGenerico<Filme, Long> {

    public FilmeDao() {
        super(Filme.class);
    }

    // 2.1. Buscar todos os filmes de um estilo específico.
    public List<Filme> buscarFilmesPorEstilo(Estilo estilo) {
        String jpql = "SELECT f FROM Filme f WHERE f.estilo = :estilo";
        TypedQuery<Filme> query = entityManager.createQuery(jpql, Filme.class);
        query.setParameter("estilo", estilo);
        return query.getResultList();
    }

    // 2.4. Buscar todos os filmes lançados em um determinado ano
    public List<Filme> buscarFilmesPorAno(String ano) {
        String jpql = "SELECT f FROM Filme f WHERE f.ano = :ano";
        TypedQuery<Filme> query = entityManager.createQuery(jpql, Filme.class);
        query.setParameter("ano", ano);
        return query.getResultList();
    }

    // 3.1. Filtrar filmes por estilo e duração mínima
    public List<Filme> filtrarFilmesPorEstiloEDuracao(Estilo estilo, Integer duracaoMinima) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Filme> cq = cb.createQuery(Filme.class);
        Root<Filme> filme = cq.from(Filme.class);

        List<Predicate> predicates = new ArrayList<>();

        if (estilo != null) {
            predicates.add(cb.equal(filme.get("estilo"), estilo));
        }
        if (duracaoMinima != null) {
            predicates.add(cb.ge(filme.get("duracao"), duracaoMinima));
        }

        cq.where(predicates.toArray(new Predicate[0]));
        return entityManager.createQuery(cq).getResultList();
    }
}

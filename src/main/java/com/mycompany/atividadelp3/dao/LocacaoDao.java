/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atividadelp3.dao;

import com.mycompany.atividadelp3.bean.Cliente;
import com.mycompany.atividadelp3.bean.Locacao;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Aluno
 */
public class LocacaoDao extends DaoGenerico<Locacao, Long> {

    public LocacaoDao() {
        super(Locacao.class);
    }

    // 2.1. Listar todas as locações de um cliente.
    public List<Locacao> listarLocacoesPorCliente(Long clienteId) {
        String jpql = "SELECT l FROM Locacao l WHERE l.cliente.id = :clienteId";
        TypedQuery<Locacao> query = entityManager.createQuery(jpql, Locacao.class);
        query.setParameter("clienteId", clienteId);
        return query.getResultList();
    }

    // 2.3. Calcular o valor total de locações em um intervalo de datas
    public BigDecimal calcularTotalLocacoesPorPeriodo(Date dataInicio, Date dataFim) {
        String jpql = "SELECT SUM(l.valor) FROM Locacao l WHERE l.dataLocacao BETWEEN :dataInicio AND :dataFim";
        TypedQuery<BigDecimal> query = entityManager.createQuery(jpql, BigDecimal.class);
        query.setParameter("dataInicio", dataInicio);
        query.setParameter("dataFim", dataFim);
        return query.getSingleResult();
    }

    // 2.5. Listar todos os clientes que locaram filmes de um estilo específico
    public List<Cliente> listarClientesPorEstiloFilme(String estilo) {
        String jpql = "SELECT DISTINCT l.cliente FROM Locacao l JOIN l.filme f WHERE f.estilo = :estilo";
        TypedQuery<Cliente> query = entityManager.createQuery(jpql, Cliente.class);
        query.setParameter("estilo", estilo);
        return query.getResultList();
    }

    // 3.2. Filtrar locações por cliente e intervalo de datas
    public List<Locacao> filtrarLocacoesPorClienteEData(Long clienteId, Date dataInicio, Date dataFim) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Locacao> cq = cb.createQuery(Locacao.class);
        Root<Locacao> locacao = cq.from(Locacao.class);

        List<Predicate> predicates = new ArrayList<>();

        if (clienteId != null) {
            predicates.add(cb.equal(locacao.get("cliente").get("id"), clienteId));
        }
        if (dataInicio != null && dataFim != null) {
            predicates.add(cb.between(locacao.get("dataLocacao"), dataInicio, dataFim));
        }

        cq.where(predicates.toArray(new Predicate[0]));
        return entityManager.createQuery(cq).getResultList();
    }
    
    
}

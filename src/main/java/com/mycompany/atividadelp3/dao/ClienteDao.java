package com.mycompany.atividadelp3.dao;

import com.mycompany.atividadelp3.bean.Cliente;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class ClienteDao extends DaoGenerico<Cliente, Long> {

    public ClienteDao() {
        super(Cliente.class);
    }

    // 3.3. Filtrar clientes por nome e telefone
    public List<Cliente> filtrarClientesPorNomeETelefone(String nome, String telefone) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Cliente> cq = cb.createQuery(Cliente.class);
        Root<Cliente> cliente = cq.from(Cliente.class);

        List<Predicate> predicates = new ArrayList<>();

        if (nome != null && !nome.isEmpty()) {
            predicates.add(cb.like(cliente.get("nome"), "%" + nome + "%"));
        }
        if (telefone != null && !telefone.isEmpty()) {
            predicates.add(cb.equal(cliente.get("telefone"), telefone));
        }

        cq.where(predicates.toArray(new Predicate[0]));
        return entityManager.createQuery(cq).getResultList();
    }
}

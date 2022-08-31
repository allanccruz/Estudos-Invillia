package com.github.allanccruz.domain.repository;

import com.github.allanccruz.domain.entities.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
public class Clientes {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public Cliente salvar (Cliente cliente) {
        entityManager.persist(cliente);
        return cliente;
    }
}

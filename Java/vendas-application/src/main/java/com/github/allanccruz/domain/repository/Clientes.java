package com.github.allanccruz.domain.repository;

import com.github.allanccruz.domain.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Clientes extends JpaRepository <Cliente, Integer> {
    List<Cliente> findByNomeLike(String nome);
}

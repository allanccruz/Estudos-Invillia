package com.github.allanccruz.domain.repository;

import com.github.allanccruz.domain.entities.Cliente;
import com.github.allanccruz.domain.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidosRepository extends JpaRepository<Pedido, Integer> {
    List<Pedido> findByCliente(Cliente cliente);
}

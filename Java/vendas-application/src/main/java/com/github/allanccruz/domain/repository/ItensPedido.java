package com.github.allanccruz.domain.repository;

import com.github.allanccruz.domain.entities.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItensPedido extends JpaRepository<ItemPedido, Integer> {
}

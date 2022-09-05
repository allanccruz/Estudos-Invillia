package com.github.allanccruz.domain.repository;

import com.github.allanccruz.domain.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutosRepository extends JpaRepository<Produto, Integer> {

}

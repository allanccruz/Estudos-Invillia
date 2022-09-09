package com.github.allanccruz.service;

import com.github.allanccruz.domain.entities.Pedido;
import com.github.allanccruz.api.dto.PedidoDTO;
import com.github.allanccruz.domain.enums.StatusPedido;

import java.util.Optional;

public interface PedidoService {
    Pedido save(PedidoDTO dto);
    Optional<Pedido> getPedido(Integer id);
    void atualizarStatus(Integer id, StatusPedido statusPedido);
}

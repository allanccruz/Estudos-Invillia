package com.github.allanccruz.service;

import com.github.allanccruz.domain.entities.Pedido;
import com.github.allanccruz.rest.dto.PedidoDTO;

public interface PedidoService {
    Pedido save(PedidoDTO dto);
}

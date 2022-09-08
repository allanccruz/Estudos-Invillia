package com.github.allanccruz.service.impl;

import com.github.allanccruz.domain.repository.PedidosRepository;
import com.github.allanccruz.service.PedidoService;
import org.springframework.stereotype.Service;

@Service
public class PedidoServiceImpl implements PedidoService {

    private PedidosRepository pedidosRepository;

    public PedidoServiceImpl(PedidosRepository pedidosRepository) {
        this.pedidosRepository = pedidosRepository;
    }
}

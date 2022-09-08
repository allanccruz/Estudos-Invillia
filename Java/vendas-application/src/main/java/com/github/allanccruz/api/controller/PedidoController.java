package com.github.allanccruz.api.controller;

import com.github.allanccruz.service.PedidoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    private PedidoService pedidoService;

    public  PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }
}

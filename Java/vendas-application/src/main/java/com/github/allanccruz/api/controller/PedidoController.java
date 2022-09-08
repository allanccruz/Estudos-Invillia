package com.github.allanccruz.api.controller;

import com.github.allanccruz.domain.entities.Pedido;
import com.github.allanccruz.rest.dto.PedidoDTO;
import com.github.allanccruz.service.PedidoService;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    private PedidoService pedidoService;

    public  PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Integer savePedido( @RequestBody PedidoDTO dto ){
        Pedido pedido = pedidoService.save(dto);
        return pedido.getId();
    }
}

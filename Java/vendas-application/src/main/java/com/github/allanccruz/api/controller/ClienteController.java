package com.github.allanccruz.api.controller;

import com.github.allanccruz.domain.entities.Cliente;
import com.github.allanccruz.domain.repository.ClientesRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/api/clientes")
public class ClienteController {

    private ClientesRepository clientesRepository;
    public ClienteController(ClientesRepository clientesRepository) {
        this.clientesRepository = clientesRepository;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity getClienteById (@PathVariable Integer id) { //Dizendo que o id virá pela URL
        Optional<Cliente> cliente = clientesRepository.findById(id);

        if(cliente.isPresent()) {
            return ResponseEntity.ok(cliente.get());
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity saveCliente(@RequestBody Cliente cliente) {
        Cliente save = clientesRepository.save(cliente);
        return ResponseEntity.ok(save);
    }

}


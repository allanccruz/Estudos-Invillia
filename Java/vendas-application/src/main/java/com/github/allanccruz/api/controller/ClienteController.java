package com.github.allanccruz.api.controller;

import com.github.allanccruz.domain.entities.Cliente;
import com.github.allanccruz.domain.repository.ClientesRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity deleteCliente(@PathVariable Integer id) {
        Optional<Cliente> cliente = clientesRepository.findById(id);

        if(cliente.isPresent()) {
            clientesRepository.delete(cliente.get());
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity updateCliente(@PathVariable Integer id,
                                        @RequestBody Cliente cliente) {
        return clientesRepository
                .findById(id)
                .map(clienteExistente -> {
                    cliente.setId(clienteExistente.getId());
                    clientesRepository.save(cliente);
                    return ResponseEntity.noContent().build();
                }).orElseGet( () -> ResponseEntity.notFound().build() );
    }

    @GetMapping
    public ResponseEntity find( Cliente filtro ){
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(
                        ExampleMatcher.StringMatcher.CONTAINING );

        Example example = Example.of(filtro, matcher);
        List<Cliente> lista = clientesRepository.findAll(example);
        return ResponseEntity.ok(lista);
    }

}


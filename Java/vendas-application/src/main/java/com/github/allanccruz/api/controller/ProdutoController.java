package com.github.allanccruz.api.controller;

import com.github.allanccruz.domain.entities.Cliente;
import com.github.allanccruz.domain.entities.Produto;
import com.github.allanccruz.domain.repository.ProdutosRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    private ProdutosRepository produtosRepository;

    public ProdutoController(ProdutosRepository produtosRepository) {
        this.produtosRepository = produtosRepository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Produto saveProduto (@RequestBody Produto produto) {
        return produtosRepository.save(produto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateProduto(@PathVariable Integer id,
                              @RequestBody Produto produto) {
        produtosRepository
                .findById(id)
                .map(p -> {
                    produto.setId(p.getId());
                    produtosRepository.save(produto);
                    return produto;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduto(@PathVariable Integer id) {
        produtosRepository
                .findById(id)
                .map(p -> {
                    produtosRepository.delete(p);
                    return Void.TYPE;
                })
                .orElseThrow( () ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/{id}")
    public Produto getProdutoById(@PathVariable Integer id) {
        return produtosRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public List<Produto> findProduto(Produto filtro ){
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(
                        ExampleMatcher.StringMatcher.CONTAINING );

        Example example = Example.of(filtro, matcher);
        return produtosRepository.findAll(example);
    }
}

package com.github.allanccruz.api.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class IndexController {

    @GetMapping
    public String hello () {
        return "API dos Carros";
    }

    @GetMapping("/carros/{id}")
    public String login (@PathVariable("login") String login, @PathVariable("senha") String senha) {
        return login + " " + senha;
    }
}

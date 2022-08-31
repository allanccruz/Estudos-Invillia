package com.github.allanccruz;

import com.github.allanccruz.domain.entities.Cliente;
import com.github.allanccruz.domain.repository.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class VendasApplication {

    @Bean
    public CommandLineRunner init (@Autowired Clientes clientes) {
        return args -> {
            clientes.salvar(new Cliente("Douglas"));
            clientes.salvar(new Cliente("Pedro"));
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }
}

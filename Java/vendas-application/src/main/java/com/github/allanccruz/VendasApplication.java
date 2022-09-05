package com.github.allanccruz;

import com.github.allanccruz.domain.entities.Cliente;
import com.github.allanccruz.domain.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VendasApplication {

    @Bean
    public CommandLineRunner commandLineRunner(@Autowired ClientesRepository clientesRepository) {
        return args -> {
            Cliente cliente = new Cliente("Fulano");
            clientesRepository.save(cliente);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }
}

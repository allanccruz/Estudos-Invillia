package com.github.allanccruz;

import com.github.allanccruz.domain.entities.Cliente;
import com.github.allanccruz.domain.entities.Pedido;
import com.github.allanccruz.domain.repository.Clientes;
import com.github.allanccruz.domain.repository.Pedidos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class VendasApplication {


    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }
}

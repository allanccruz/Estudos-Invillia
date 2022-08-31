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

            List<Cliente> todosClientes = clientes.buscarTodos();
            todosClientes.forEach(System.out::println);

            System.out.println("Atualizando clientes");
            todosClientes.forEach(c -> {
                c.setNome(c.getNome() + " atualizado.");
                clientes.atualizar(c);
            });

            todosClientes = clientes.buscarTodos();
            todosClientes.forEach(System.out::println);

            System.out.println("Buscando clientes");
            clientes.buscarPorNome("Cli").forEach(System.out::println);

            System.out.println("Deletando clientes");
            clientes.buscarTodos().forEach(c -> {
                clientes.deletar(c);
            });

            todosClientes = clientes.buscarTodos();
            if(todosClientes.isEmpty()){
                System.out.println("Nenhum cliente encontrado.");
            }else{
                todosClientes.forEach(System.out::println);
            }

        };
    }

    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }
}

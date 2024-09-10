package io.github.vedenilsonjr;

import io.github.vedenilsonjr.Repository.Clientes;
import io.github.vedenilsonjr.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class VendasApplication {

    @Bean
    public CommandLineRunner init(@Autowired Clientes clientes){
        return args -> {
            System.out.println("Cadastrando clientes");
            clientes.salvar(new Cliente("Vadenilson"));
            clientes.salvar(new Cliente("Vivian"));
            clientes.salvar(new Cliente("Ester"));
            clientes.salvar(new Cliente("Pedro"));
            clientes.salvar(new Cliente("Alvares"));
            clientes.salvar(new Cliente("Cabral"));

            List<Cliente> todosClientes = clientes.obterTodos();
            todosClientes.forEach(System.out::println);

            clientes.buscarPorNome("al");






            todosClientes.forEach(c ->{
                clientes.deletar(c.getId());
            });

            todosClientes = clientes.obterTodos();
            if (todosClientes.isEmpty()){
                System.out.println("N/A");
            }else {
                System.out.println("found");
            }









        };
    }

    @GetMapping("/hello")
    public String HelloWorld(){
        return "Hi";
    }

    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }
}

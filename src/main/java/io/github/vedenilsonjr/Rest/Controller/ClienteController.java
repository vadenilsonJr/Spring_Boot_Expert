package io.github.vedenilsonjr.Rest.Controller;

import io.github.vedenilsonjr.Repository.Clientes;
import io.github.vedenilsonjr.entity.Cliente;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private Clientes clientes;

    public ClienteController(Clientes clientes) {
        this.clientes = clientes;
    }

    @RequestMapping("/{id}")
    public Cliente getById(@PathVariable int id) {

        return clientes.findById(id).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));


    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente save (@RequestBody Cliente cliente) {
        return clientes.save(cliente);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Cliente delete (@PathVariable int id) {
        return clientes.findById(id).map( cliente -> {
            clientes.delete(cliente);
            return cliente;
        }).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update (@PathVariable int id, @RequestBody Cliente cliente) {

         clientes
                .findById(id)
                .map(clienteExists -> {
                    cliente.setId(clienteExists.getId());
                    clientes.save(cliente);
                    return cliente;
                }).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public List<Cliente> find( Cliente filtro ){
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(
                        ExampleMatcher.StringMatcher.CONTAINING );

        Example example = Example.of(filtro, matcher);
        return clientes.findAll(example);
    }

    }

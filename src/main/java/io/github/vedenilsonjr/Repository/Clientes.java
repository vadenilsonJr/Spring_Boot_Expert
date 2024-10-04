package io.github.vedenilsonjr.Repository;

import io.github.vedenilsonjr.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;


public interface Clientes extends JpaRepository<Cliente, Integer> {

}


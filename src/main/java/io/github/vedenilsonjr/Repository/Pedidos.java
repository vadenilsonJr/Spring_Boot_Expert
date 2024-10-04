package io.github.vedenilsonjr.Repository;

import io.github.vedenilsonjr.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Pedidos extends JpaRepository<Pedido, Integer> {
}

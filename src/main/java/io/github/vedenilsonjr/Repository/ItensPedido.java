package io.github.vedenilsonjr.Repository;

import io.github.vedenilsonjr.entity.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItensPedido extends JpaRepository<ItemPedido, Integer> {
}

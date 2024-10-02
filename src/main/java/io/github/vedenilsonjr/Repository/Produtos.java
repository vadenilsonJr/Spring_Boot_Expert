package io.github.vedenilsonjr.Repository;

import io.github.vedenilsonjr.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Produtos extends JpaRepository<Produto, Integer> {
}

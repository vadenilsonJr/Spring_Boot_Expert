package io.github.vedenilsonjr.service.impl;

import io.github.vedenilsonjr.Repository.Pedidos;
import io.github.vedenilsonjr.service.PedidoService;
import org.springframework.stereotype.Service;

@Service
public class PedidoServiceImpl implements PedidoService {

    private Pedidos pedidos;

    public Pedidos getPedidos() {
        return pedidos;
    }

    public void setPedidos(Pedidos pedidos) {
        this.pedidos = pedidos;
    }
}

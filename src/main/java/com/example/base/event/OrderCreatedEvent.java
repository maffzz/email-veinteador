package com.example.base.event;

import com.example.base.domain.Pedido;
import java.util.List;

public class OrderCreatedEvent {
    private Long orderId;
    private String email;
    private List<String> productos;

    public OrderCreatedEvent(Pedido pedido) {
        this.orderId = pedido.getId();
        this.email = pedido.getEmail();
        this.productos = pedido.getProductos();
    }

    public Long getOrderId() {
        return orderId;
    }

    public String getEmail() {
        return email;
    }

    public List<String> getProductos() {
        return productos;
    }
}
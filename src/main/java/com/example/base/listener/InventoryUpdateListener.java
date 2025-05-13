package com.example.base.listener;


import com.example.base.event.OrderCreatedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class InventoryUpdateListener {

    @EventListener
    public void handleOrderCreatedEvent(OrderCreatedEvent event) {
        System.out.println("Actualizando inventario para el pedido: " + event.getOrderId());
        System.out.println("Reduciendo stock de productos: " + String.join(", ", event.getProductos()));
    }
}
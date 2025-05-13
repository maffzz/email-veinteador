package com.example.base.listener;


import com.example.base.event.OrderCreatedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class AuditLogListener {

    @EventListener
    public void handleOrderCreatedEvent(OrderCreatedEvent event) {
        System.out.println("Registrando en logs de auditoría el pedido: " + event.getOrderId());
        System.out.println("Detalles: Email=" + event.getEmail() + ", Productos=" + String.join(", ", event.getProductos()));
    }
}
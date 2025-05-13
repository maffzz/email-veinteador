package com.example.base.listener;

import com.example.base.event.OrderCreatedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class AuditLogListener {
    private static final Logger logger = LoggerFactory.getLogger(AuditLogListener.class);

    @EventListener
    public void handleOrderCreatedEvent(OrderCreatedEvent event) {
        logger.info("AUDIT LOG - Pedido creado - ID: {}, Email: {}, Productos: {}",
                event.getOrderId(),
                event.getEmail(),
                String.join(", ", event.getProductos()));}
}
package com.example.base.listener;

import com.example.base.domain.Inventario;
import com.example.base.event.OrderCreatedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class InventoryUpdateListener {

    @EventListener
    public void handleOrder(OrderCreatedEvent event) {
        Inventario inventario = new Inventario();
        inventario.setId(event.getOrderId());

        Integer cant = event.getProductos().size();

        inventario.setCantidad(inventario.getCantidad() - cant);

        System.out.println("ACTUALIZANDO INVENTARIO -> cantidad restante: " + inventario.getCantidad().toString());}
}
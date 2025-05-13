package com.example.base.controller;
import com.example.base.domain.Pedido;
import com.example.base.event.OrderCreatedEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final ApplicationEventPublisher eventPublisher;

    public OrderController(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    @PostMapping
    public String createOrder(@RequestBody Pedido pedido) {

        eventPublisher.publishEvent(new OrderCreatedEvent(pedido));

        return "Pedido creado exitosamente. ID: " + pedido.getId();
    }
}
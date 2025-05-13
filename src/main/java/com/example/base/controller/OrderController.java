package com.example.base.controller;
import com.example.base.domain.Pedido;
import com.example.base.event.OrderCreatedEvent;
import com.example.base.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
    private final PedidoService service;
    private final ApplicationEventPublisher eventPublisher;


    @PostMapping
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public String createOrder(@RequestBody Pedido pedido) {

        eventPublisher.publishEvent(new OrderCreatedEvent(pedido));
        pedido = service.crearPedido(pedido);
        return "Pedido creado exitosamente. ID: " + pedido.getId();
    }
}
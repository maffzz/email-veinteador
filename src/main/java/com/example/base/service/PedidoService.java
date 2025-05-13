package com.example.base.service;

import com.example.base.domain.Pedido;
import com.example.base.event.EmailNotificacionEvent;
import com.example.base.event.OrderCreatedEvent;
import com.example.base.repository.PedidosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PedidoService {
    private final PedidosRepository repository;
    private final ApplicationEventPublisher eventPublisher;

    public Pedido crearPedido(Pedido pedido) {
        pedido.setId(pedido.getId());
        repository.save(pedido);
        eventPublisher.publishEvent(new EmailNotificacionEvent(this, pedido.getEmail()));
        eventPublisher.publishEvent(new OrderCreatedEvent(pedido));
        return pedido;}}

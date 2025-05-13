package com.example.base.listener;

import com.example.base.event.WelcomeEmailEvent;
import com.example.base.service.EmailService;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class EmailNotificationListener {

    private final EmailService emailService;

    public EmailNotificationListener(EmailService emailService) {
        this.emailService = emailService;}

    @EventListener
    @Async
    public void sendEmail(WelcomeEmailEvent welcomeEmailEvent) {
        try {
            Thread.sleep(10000);}
        catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Thread was interrupted", e);}
        emailService.sendEmail(welcomeEmailEvent.getEmail(), "bienvenido", "hola " + welcomeEmailEvent.getName() + ", bienvenido a nuestra plataforma");}}


//@Component
//public class EmailNotificationListener {
//
//    @EventListener
//    public void handleOrderCreatedEvent(OrderCreatedEvent event) {
//        // Simular envío de correo
//        System.out.println("Enviando correo de confirmación para el pedido: " + event.getOrderId());
//        System.out.println("Correo enviado a: " + event.getEmail());
//        System.out.println("Productos: " + String.join(", ", event.getProductos()));
//    }
//}
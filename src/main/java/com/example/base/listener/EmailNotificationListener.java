package com.example.base.listener;

import com.example.base.event.EmailNotificacionEvent;
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
    public void sendEmail(EmailNotificacionEvent welcomeEmailEvent) {
        try {
            Thread.sleep(10000);}
        catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Thread was interrupted", e);}
        emailService.sendEmail(welcomeEmailEvent.getEmail(), "pedido enviado", "hola, tu pedido ha sido enviado");}
}

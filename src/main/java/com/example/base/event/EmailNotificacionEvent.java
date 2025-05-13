package com.example.base.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class EmailNotificacionEvent extends ApplicationEvent {
    final private String email;

    public EmailNotificacionEvent(Object source, String email) {
        super(source);
        this.email = email;}}
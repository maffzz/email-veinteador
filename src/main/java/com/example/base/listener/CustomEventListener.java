package com.example.base.listener;

import com.example.eventos.event.CustomEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class CustomEventListener {
    @EventListener
    @Async
    public void handleCustomEvent(CustomEvent event) {
        System.out.println("[ASYNC] Handling CustomEvent: " + event.getMessage());
    }

}

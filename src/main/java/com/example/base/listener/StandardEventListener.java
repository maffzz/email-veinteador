package com.example.base.listener;

import com.example.eventos.event.StandardEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class StandardEventListener {
    @Async
    @EventListener
    public void handleStandardEvent(StandardEvent event) {
        System.out.println("[ASYNC] Handling StandardEvent: " + event.getMessage());
    }
}
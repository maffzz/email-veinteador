package com.example.base.controller;

import com.example.base.event.CustomEvent;
import com.example.base.event.StandardEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventController {

    private final ApplicationEventPublisher publisher;

    public EventController(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    @GetMapping("/standard")
    public String triggerStandardEvent() {
        publisher.publishEvent(new StandardEvent(this, "Standard Event Triggered"));
        return "Standard Event published";
    }

    @GetMapping("/custom")
    public String triggerCustomEvent() {
        publisher.publishEvent(new CustomEvent("Custom Event Triggered"));
        return "Custom Event published";

    }
}
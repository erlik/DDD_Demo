package com.versusmind.demo.infrastructure.ports;

import com.versusmind.demo.core.domain.requestBus.events.Event;
import com.versusmind.demo.core.domain.requestBus.events.EventResponse;
import com.versusmind.demo.domain.handlers.GetAllConsumerEvent;
import com.versusmind.demo.domain.handlers.GetByIdConsumerEvent;
import com.versusmind.demo.domain.ports.ConsumerPort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class ConsumerPortImpl extends AbstractPort implements ConsumerPort {

    @Override
    @GetMapping("/")
    public EventResponse getAll() {
        return requestBusFactory.handle(new GetAllConsumerEvent());
    }

    @Override
    @GetMapping("/{id}")
    public EventResponse getById(@PathVariable UUID id) {
        Event e = new GetByIdConsumerEvent(id);
        return requestBusFactory.handle(e);
    }
}
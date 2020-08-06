package com.versusmind.demo.infrastructure.ports;

import com.versusmind.demo.core.domain.handlerBus.HandlerResponse;
import com.versusmind.demo.domain.handlers.GetAllConsumerEvent;
import com.versusmind.demo.domain.handlers.GetByIdConsumerEvent;
import com.versusmind.demo.domain.ports.ConsumerPort;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class ConsumerPortImpl extends AbstractPort implements ConsumerPort {

    @Override
    @GetMapping
    public HandlerResponse getAll() {
        return handlerBusDispatcher.handle(new GetAllConsumerEvent());
    }

    @Override
    @GetMapping("{id}")
    public HandlerResponse getById(@PathVariable("id") UUID id) {
        HandlerEvent e = new GetByIdConsumerEvent(id);
        return handlerBusDispatcher.handle(e);
    }
}
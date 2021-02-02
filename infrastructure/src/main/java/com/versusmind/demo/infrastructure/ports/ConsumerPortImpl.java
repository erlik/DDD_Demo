package com.versusmind.demo.infrastructure.ports;

import com.versusmind.demo.core.domain.requestBus.HandlerResponse;
import com.versusmind.demo.core.domain.requestBus.EventDomain;
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
    public HandlerResponse getAll() {
        return requestBusFactory.handle(new GetAllConsumerEvent());
    }

    @Override
    @GetMapping("/{id}")
    public HandlerResponse getById(@PathVariable UUID id) {
        EventDomain e = new GetByIdConsumerEvent(id);
        return requestBusFactory.handle(e);
    }
}
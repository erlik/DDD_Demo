package com.versusmind.demo.core.infra;

import com.versusmind.demo.core.domain.Handler;
import com.versusmind.demo.core.domain.HandlerResponse;
import com.versusmind.demo.core.domain.requestBus.RequestBusFactory;
import com.versusmind.demo.core.domain.requestBus.events.Event;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Component
public class RequestBusFactoryImpl implements RequestBusFactory {

    @Autowired
    private final Set<Handler> handlerBus = new HashSet<>();

    @Override
    public <E extends Event> HandlerResponse handle(E trigger) {
        var handler = this.getHandler(trigger);
        if (handler.isPresent()) {
            return handler.get().handle(trigger);
        }

        return HandlerResponse.WithFault(new Exception("Handler not found"));
    }

    @Override
    public <E extends Event> void unregister(E trigger) {
        var handler = this.getHandler(trigger);
        handler.ifPresent(handlerBus::remove);
    }

    private Optional<Handler> getHandler(Event handler) {
        var handlerName = handler.getClass().getName();
        return handlerBus
                .stream()
                .filter(c -> c.getEvent().equals(handlerName))
                .findFirst();
    }
}

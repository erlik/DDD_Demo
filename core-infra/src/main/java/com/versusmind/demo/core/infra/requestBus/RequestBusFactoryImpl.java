package com.versusmind.demo.core.infra.requestBus;

import com.versusmind.demo.core.domain.exceptions.NotFoundException;
import com.versusmind.demo.core.domain.requestBus.EventDomain;
import com.versusmind.demo.core.domain.requestBus.Handler;
import com.versusmind.demo.core.domain.requestBus.HandlerResponse;
import com.versusmind.demo.core.domain.requestBus.RequestBusFactory;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Named
public class RequestBusFactoryImpl implements RequestBusFactory {

    private final Set<Handler> handlerBus;

    @Inject
    public RequestBusFactoryImpl(Set<Handler> handlerBus) {
        this.handlerBus = handlerBus;
        log.info("Handler : " + this.handlerBus);
    }

    @Override
    public <E extends EventDomain> HandlerResponse handle(E trigger) {
        Optional<Handler> handler = this.getHandler(trigger);

        return handler.map(h -> HandlerResponse.WithValue(h.handle(trigger)))
                .orElseGet(() -> HandlerResponse.WithFault(new NotFoundException("Handler not found with trigger : " + trigger.getClass().getName())));
    }

    @Override
    public Set<Handler> getHandlers() {
        return handlerBus;
    }

    @Override
    public <E extends EventDomain> void unregister(E trigger) {
        var handler = this.getHandler(trigger);
        handler.ifPresent(handlerBus::remove);
    }

    @Override
    public Optional<Handler> getHandler(EventDomain handler) {
        var handlerName = handler.getClass().getName();
        return handlerBus
                .stream()
                .filter(c -> c.getEvent().equals(handlerName))
                .findFirst();
    }
}

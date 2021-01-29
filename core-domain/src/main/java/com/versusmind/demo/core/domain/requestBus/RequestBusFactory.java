package com.versusmind.demo.core.domain.requestBus;

import java.util.Optional;
import java.util.Set;

public interface RequestBusFactory {

    <E extends Event> HandlerResponse handle(E event);

    <E extends Event> Optional<Handler>  getHandler(E event);

    Set<Handler> getHandlers();

    <E extends Event> void unregister(E trigger);
}

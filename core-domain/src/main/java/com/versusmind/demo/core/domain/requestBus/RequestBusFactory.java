package com.versusmind.demo.core.domain.requestBus;

import java.util.Optional;
import java.util.Set;

public interface RequestBusFactory {

    <E extends EventDomain> HandlerResponse handle(E event);

    <E extends EventDomain> Optional<Handler<E>>  getHandler(E event);

    <E extends EventDomain> Set<Handler<E>> getHandlers();

    <E extends EventDomain> void unregister(E trigger);
}

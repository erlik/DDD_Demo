package com.versusmind.demo.core.domain.handlerBus;

import java.util.Optional;

public interface HandlerBusDispatcher {

    void register(HandlerRegister object);

    <R> R handle(Object object);

    void unregister(Object object);

    Optional<HandlerRegister> getHandler(Object h);
}

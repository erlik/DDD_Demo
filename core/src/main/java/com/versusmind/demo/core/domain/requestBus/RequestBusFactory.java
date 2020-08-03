package com.versusmind.demo.core.domain.requestBus;

public interface RequestBusFactory {

    void register(RequestHandlerRegister object);

    <R> R handle(Object object);

    void unregister(Object object);
}

package com.versusmind.demo.core.handlers;

public interface HandlerDispatcher<E, R extends HandlerResponse> {
    void registre(HandlerRegister handler);

    R handle(E event);
}
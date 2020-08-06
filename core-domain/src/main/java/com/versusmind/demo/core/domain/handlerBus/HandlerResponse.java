package com.versusmind.demo.core.domain.handlerBus;

import lombok.Getter;

import java.util.UUID;

public class HandlerResponse {

    @Getter
    private UUID id = UUID.randomUUID();

    @Getter
    private Object data = null;

    @Getter
    private Exception fault = null;

    private HandlerResponse() {
    }

    private HandlerResponse(Object d) {
        this.data = d;
    }

    private HandlerResponse( Exception e) {
        this.fault = e;
    }

    public boolean isValid() {
        return fault == null;
    }

    public static HandlerResponse WithValue(Object o) {
        return new HandlerResponse(o);
    }

    public static HandlerResponse WithoutValue() {
        return new HandlerResponse();
    }

    public static HandlerResponse WithFault(Exception e) {
        return new HandlerResponse(e);
    }
}

package com.versusmind.demo.core.domain;

import lombok.Getter;

import java.util.UUID;

public class HandlerResponse {
    @Getter
    private UUID id = UUID.randomUUID();

    @Getter
    private Object data = null;

    @Getter
    private Exception exception = null;

    public boolean isValid() {
        return exception == null;
    }

    public String getExceptionMessage(){
        return exception != null ? exception.getMessage() : null;
    }

    public Class<?> getExceptionType(){
        return exception != null ? exception.getClass() : null;
    }

    private HandlerResponse() {
    }

    private HandlerResponse(Object d) {
        this.data = d;
    }

    private HandlerResponse( Exception e) {
        this.exception = e;
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

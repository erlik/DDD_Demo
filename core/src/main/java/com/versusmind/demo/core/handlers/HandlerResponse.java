package com.versusmind.demo.core.handlers;

import lombok.Builder;
import lombok.Getter;

public class HandlerResponse {
    @Getter
    protected boolean isSuccess;
    @Getter
    protected Object value;
    @Getter
    protected Exception fault;

    public boolean isValid() {
        return fault == null;
    }

    public static HandlerResponse WithValue(Object value) {
        var response = new HandlerResponse();
        response.value = value;
        return response;
    }

    public static HandlerResponse WithoutValue() {
        return new HandlerResponse();
    }

    public static HandlerResponse WithFault(Exception fault) {
        var response = new HandlerResponse();
        response.fault = fault;
        return response;
    }

}

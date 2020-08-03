package com.versusmind.demo.core.domain.requestBus.events;

import lombok.Getter;

public class RequestResponse {
    @Getter
    protected Object value = null;

    @Getter
    protected Exception fault = null;

    @Getter
    protected boolean valid = true;

    public static RequestResponse WithValue(Object v) {
        var e = new RequestResponse();
        e.value = v;
        return e;
    }

    public static RequestResponse WithoutValue() {
        return new RequestResponse();
    }

    public static RequestResponse WithFault(Exception v) {
        var e = new RequestResponse();
        e.fault = v;
        e.valid = false;
        return e;
    }

}

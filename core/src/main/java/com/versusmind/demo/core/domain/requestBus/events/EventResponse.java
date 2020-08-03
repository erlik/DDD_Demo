package com.versusmind.demo.core.domain.requestBus.events;

import lombok.Getter;

public class EventResponse extends RequestResponse {
    @Getter
    protected Object value = null;

    @Getter
    protected Exception fault = null;

    @Getter
    protected boolean valid = true;

    public static EventResponse WithValue(Object v) {
        var e = new EventResponse();
        e.value = v;
        return e;
    }

    public static EventResponse WithoutValue() {
        return new EventResponse();
    }

    public static EventResponse WithFault(Exception v) {
        var e = new EventResponse();
        e.fault = v;
        e.valid = false;
        return e;
    }

}

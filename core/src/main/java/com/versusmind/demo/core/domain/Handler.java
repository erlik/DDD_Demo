package com.versusmind.demo.core.domain;

import com.versusmind.demo.core.domain.requestBus.events.Event;

public interface Handler<E extends Event> {
        String getEvent();

        HandlerResponse handle(E object);
    }

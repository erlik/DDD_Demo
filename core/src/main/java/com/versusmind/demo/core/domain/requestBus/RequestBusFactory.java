package com.versusmind.demo.core.domain.requestBus;

import com.versusmind.demo.core.domain.HandlerResponse;
import com.versusmind.demo.core.domain.requestBus.events.Event;

public interface RequestBusFactory {

    <E extends Event> HandlerResponse handle(E event);

    <E extends Event> void unregister(E trigger);
}

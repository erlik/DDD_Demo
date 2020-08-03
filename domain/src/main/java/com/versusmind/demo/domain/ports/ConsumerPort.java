package com.versusmind.demo.domain.ports;

import com.versusmind.demo.core.domain.requestBus.events.EventResponse;
import com.versusmind.demo.core.domain.ports.Port;

import java.util.UUID;

public interface ConsumerPort extends Port {
    EventResponse getAll();
    EventResponse getById(UUID id);
}

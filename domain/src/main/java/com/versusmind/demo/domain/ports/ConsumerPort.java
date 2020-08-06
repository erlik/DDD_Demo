package com.versusmind.demo.domain.ports;

import com.versusmind.demo.core.domain.handlerBus.HandlerResponse;
import com.versusmind.demo.core.domain.ports.Port;

import java.util.UUID;

public interface ConsumerPort extends Port {
    HandlerResponse getAll();
    HandlerResponse getById(UUID id);
}

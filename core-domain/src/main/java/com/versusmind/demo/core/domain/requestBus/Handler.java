package com.versusmind.demo.core.domain.requestBus;

import java.time.LocalDateTime;

public interface Handler<E extends EventDomain> {
    String getEvent();

    String getVersion();

    LocalDateTime getCreationDate();

    HandlerResponse handle(E object);
}

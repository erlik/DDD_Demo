package com.versusmind.demo.core.domain.requestBus;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

public abstract class AbstractEventDomain implements EventDomain{
    @Getter
    private final UUID id = UUID.randomUUID();

    @Getter
    @Setter
    private UUID linkedId;

    @Getter
    private final LocalDateTime creationDate = LocalDateTime.now();
}

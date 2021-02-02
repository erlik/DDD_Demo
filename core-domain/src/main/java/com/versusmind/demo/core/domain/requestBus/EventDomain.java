package com.versusmind.demo.core.domain.requestBus;

import java.time.LocalDateTime;
import java.util.UUID;

public interface EventDomain {
    UUID getId();

    UUID getLinkedId();

    void setLinkedId(UUID linkedId);

    LocalDateTime getCreationDate();
}

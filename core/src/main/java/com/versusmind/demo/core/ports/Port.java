package com.versusmind.demo.core.ports;

import com.versusmind.demo.core.handlers.events.EventResponse;

import java.util.List;
import java.util.UUID;

public interface Port<M> {
    default EventResponse getAll() {
        return EventResponse.WithFault(new Exception("port not implemented"));
    }

    default EventResponse findAllById(List<UUID> ids) {
        return EventResponse.WithFault(new Exception("port not implemented"));
    }

    default EventResponse getById(UUID id) {
        return EventResponse.WithFault(new Exception("port not implemented"));
    }

    default EventResponse update(M m) {
        return EventResponse.WithFault(new Exception("port not implemented"));
    }

    default EventResponse save(M m) {
        return EventResponse.WithFault(new Exception("port not implemented"));
    }

}

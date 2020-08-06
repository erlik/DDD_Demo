package com.versusmind.demo.core.domain.ports;



import com.versusmind.demo.core.domain.handlerBus.HandlerResponse;

import java.util.List;
import java.util.UUID;

public interface Port<M> {
    default HandlerResponse getAll() {
        return HandlerResponse.WithFault(new Exception("port not implemented"));
    }

    default HandlerResponse findAllById(List<UUID> ids) {
        return HandlerResponse.WithFault(new Exception("port not implemented"));
    }

    default HandlerResponse getById(UUID id) {
        return HandlerResponse.WithFault(new Exception("port not implemented"));
    }

    default HandlerResponse update(M m) {
        return HandlerResponse.WithFault(new Exception("port not implemented"));
    }

    default HandlerResponse save(M m) {
        return HandlerResponse.WithFault(new Exception("port not implemented"));
    }

}

package com.versusmind.demo.infrastructure.ports;

import com.versusmind.demo.core.handlers.events.EventBusDispatcher;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractPort {

    @Autowired
    protected EventBusDispatcher eventBusDispatcher;
}

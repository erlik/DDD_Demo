package com.versusmind.demo.infrastructure.ports;


import com.versusmind.demo.core.domain.handlerBus.HandlerBusDispatcher;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractPort {

    @Autowired
    protected HandlerBusDispatcher handlerBusDispatcher;
}

package com.versusmind.demo.infrastructure.ports;


import com.versusmind.demo.core.domain.requestBus.RequestBusFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractPort {

    @Autowired
    protected RequestBusFactory requestBusFactory;
}

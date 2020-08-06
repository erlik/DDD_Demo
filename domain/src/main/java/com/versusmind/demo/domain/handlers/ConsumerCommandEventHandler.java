package com.versusmind.demo.domain.handlers;

import com.versusmind.demo.core.domain.handlerBus.annotations.Handler;
import com.versusmind.demo.core.domain.handlerBus.HandlerResponse;
import com.versusmind.demo.domain.ConsumerValueObject;
import com.versusmind.demo.domain.adapters.ConsumerAdapter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class ConsumerCommandEventHandler {

    @Autowired
    private ConsumerAdapter adapter;

    @Handler
    public HandlerResponse getAll(GetAllConsumerEvent event) {
        List<ConsumerValueObject> consumers;
        if (event.getUuids() == null || event.getUuids().isEmpty()) {
            consumers = adapter.findAll();
        } else {
            consumers = adapter.findAll(event.getUuids());
        }
        return HandlerResponse.WithValue(consumers);
    }

    @Handler
    public HandlerResponse getById(GetByIdConsumerEvent event) {
        try {
            return HandlerResponse.WithValue(adapter.getById(event.getUuid()));
        } catch (Exception e) {
            return HandlerResponse.WithFault(e);
        }
    }
}

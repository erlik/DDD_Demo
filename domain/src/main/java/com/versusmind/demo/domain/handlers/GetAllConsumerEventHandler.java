package com.versusmind.demo.domain.handlers;

import com.versusmind.demo.core.annotations.EventHandler;
import com.versusmind.demo.domain.ConsumerValueObject;
import com.versusmind.demo.domain.adapters.ConsumerAdapter;
import com.versusmind.demo.core.handlers.events.EventResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class GetAllConsumerEventHandler {

    @Autowired
    private ConsumerAdapter adapter;

    @EventHandler
    public EventResponse handle(GetAllConsumerEvent event) {
        List<ConsumerValueObject> consumers;
        if (event.getUuids() == null || event.getUuids().isEmpty()) {
            consumers = adapter.findAll();
        } else {
            consumers = adapter.findAll(event.getUuids());
        }
        return EventResponse.WithValue(consumers);
    }
}

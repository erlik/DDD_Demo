package com.versusmind.demo.domain.handlers;

import com.versusmind.demo.core.domain.HandlerResponse;
import com.versusmind.demo.core.domain.requestBus.AbstractHandler;
import com.versusmind.demo.domain.ConsumerValueObject;
import com.versusmind.demo.domain.adapters.ConsumerAdapter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class GetAllConsumerEventHandler extends AbstractHandler<GetAllConsumerEvent> {

    @Autowired
    private ConsumerAdapter adapter;

    @Override
    public HandlerResponse handle(GetAllConsumerEvent event) {
        List<ConsumerValueObject> consumers;
        if (event.getUuids() == null || event.getUuids().isEmpty()) {
            consumers = adapter.findAll();
        } else {
            consumers = adapter.findAll(event.getUuids());
        }
        return HandlerResponse.WithValue(consumers);
    }
}

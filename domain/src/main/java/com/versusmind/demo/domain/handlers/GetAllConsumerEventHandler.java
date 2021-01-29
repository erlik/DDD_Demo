package com.versusmind.demo.domain.handlers;

import com.versusmind.demo.core.domain.requestBus.AbstractHandler;
import com.versusmind.demo.core.domain.requestBus.HandlerResponse;
import com.versusmind.demo.domain.ConsumerValueObject;
import com.versusmind.demo.domain.adapters.ConsumerAdapter;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Named;
import java.util.List;

@Slf4j
@Named
public class GetAllConsumerEventHandler extends AbstractHandler<GetAllConsumerEvent> {

    private final ConsumerAdapter adapter;

    public GetAllConsumerEventHandler(ConsumerAdapter adapter) {
        this.adapter = adapter;
    }

    public HandlerResponse handle(GetAllConsumerEvent event) {
        List<ConsumerValueObject> consumers = (event.getUuids() == null || event.getUuids().isEmpty())
                ?  adapter.findAll()
                :  adapter.findAll(event.getUuids());

        return HandlerResponse.WithValue(consumers);
    }
}
package com.versusmind.demo.domain.handlers;

import com.versusmind.demo.core.domain.annotations.Handler;
import com.versusmind.demo.core.domain.requestBus.events.EventResponse;
import com.versusmind.demo.domain.adapters.ConsumerAdapter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class GetByIdConsumerEventHandler {

    @Autowired
    private ConsumerAdapter adapter;

    @Handler
    public EventResponse getById(GetByIdConsumerEvent event) {
        try {
            return EventResponse.WithValue(adapter.getById(event.getUuid()));
        } catch (Exception e) {
            return EventResponse.WithFault(e);
        }
    }
}

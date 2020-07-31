package com.versusmind.demo.domain.handlers;

import com.versusmind.demo.core.annotations.EventHandler;
import com.versusmind.demo.domain.adapters.ConsumerAdapter;
import com.versusmind.demo.core.handlers.events.EventResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class GetByIdConsumerEventHandler {

    @Autowired
    private ConsumerAdapter adapter;

    @EventHandler
    public EventResponse handle(GetByIdConsumerEvent event) {
        try {
            return EventResponse.WithValue(adapter.getById(event.getUuid()));
        } catch (Exception e) {
            return EventResponse.WithFault(e);
        }
    }
}

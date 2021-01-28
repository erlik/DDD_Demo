package com.versusmind.demo.domain.handlers;

import com.versusmind.demo.core.domain.HandlerResponse;
import com.versusmind.demo.core.domain.requestBus.AbstractHandler;
import com.versusmind.demo.domain.adapters.ConsumerAdapter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class GetByIdConsumerEventHandler extends AbstractHandler<GetByIdConsumerEvent> {

    @Autowired
    private ConsumerAdapter adapter;

    @Override
    public HandlerResponse handle(GetByIdConsumerEvent event) {
        try {
            return HandlerResponse.WithValue(adapter.getById(event.getUuid()));
        } catch (Exception e) {
            return HandlerResponse.WithFault(e);
        }
    }
}

package com.versusmind.demo.domain.handlers;

import com.versusmind.demo.core.domain.exceptions.NotFoundException;
import com.versusmind.demo.core.domain.requestBus.AbstractHandler;
import com.versusmind.demo.core.domain.requestBus.HandlerResponse;
import com.versusmind.demo.domain.ConsumerValueObject;
import com.versusmind.demo.domain.adapters.ConsumerAdapter;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Named;
import java.util.Optional;

@Slf4j
@Named
public class GetByIdConsumerEventHandler extends AbstractHandler<GetByIdConsumerEvent> {

    private final ConsumerAdapter adapter;

    public GetByIdConsumerEventHandler(ConsumerAdapter adapter) {
        this.adapter = adapter;
    }

    public HandlerResponse handle(GetByIdConsumerEvent event) {
        Optional<ConsumerValueObject> consumer = adapter.getById(event.getUuid());

        return consumer.map(HandlerResponse::WithValue)
                .orElseGet(() -> HandlerResponse.WithFault(new NotFoundException("Consumer not found with id: " + event.getUuid())));

    }
}

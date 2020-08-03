package com.versusmind.demo.domain.handlers;

import com.versusmind.demo.core.domain.requestBus.events.Event;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Component
public class GetByIdConsumerEvent implements Event {
    @Getter
    @Setter
    private UUID uuid;
}

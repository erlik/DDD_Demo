package com.versusmind.demo.domain.handlers;

import com.versusmind.demo.core.domain.requestBus.events.Event;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Component
public class GetAllConsumerEvent implements Event {
    @Getter
    @Setter
    private List<UUID> uuids = new ArrayList<>();
}

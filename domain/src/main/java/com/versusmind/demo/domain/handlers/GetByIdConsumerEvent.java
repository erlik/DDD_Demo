package com.versusmind.demo.domain.handlers;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Component
public class GetByIdConsumerEvent {
    @Getter
    private UUID uuid;
}

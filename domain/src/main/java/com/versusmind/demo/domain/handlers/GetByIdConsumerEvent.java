package com.versusmind.demo.domain.handlers;

import com.versusmind.demo.core.domain.requestBus.AbstractEventDomain;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.inject.Named;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Named
public class GetByIdConsumerEvent extends AbstractEventDomain {
    @Getter
    @Setter
    private UUID uuid;
}

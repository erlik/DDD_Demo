package com.versusmind.demo.domain;

import com.versusmind.demo.core.domain.ValueObject;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Getter
@Setter
@Component
public class ConsumerValueObject implements ValueObject {
    private UUID id;
    private String firstname;
    private String lastname;
}

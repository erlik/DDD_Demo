package com.versusmind.demo.domain;

import com.versusmind.demo.core.domain.ValueObject;
import lombok.Getter;
import lombok.Setter;

import javax.inject.Named;
import java.util.UUID;

@Getter
@Setter
@Named
public class ConsumerValueObject implements ValueObject {
    private UUID id;
    private String firstname;
    private String lastname;
}

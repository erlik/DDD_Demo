package com.versusmind.demo.core.domain.requestBus;

import lombok.Getter;

import java.lang.reflect.ParameterizedType;
import java.time.LocalDateTime;

public abstract class AbstractHandler<E extends Event> implements Handler<E> {

    @Getter
    protected String version;

    @Getter
    private LocalDateTime creationDate = LocalDateTime.now();

    @Override
    public String getEvent() {
        return ((Class<E>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0])
                .getName();
    }

}

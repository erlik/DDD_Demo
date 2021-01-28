package com.versusmind.demo.core.domain.requestBus;

import com.versusmind.demo.core.domain.Handler;
import com.versusmind.demo.core.domain.requestBus.events.Event;

import java.lang.reflect.ParameterizedType;

public abstract class AbstractHandler<E extends Event> implements Handler<E> {

    public String getEvent() {
        return ((Class<E>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0])
                .getName();
    }
}

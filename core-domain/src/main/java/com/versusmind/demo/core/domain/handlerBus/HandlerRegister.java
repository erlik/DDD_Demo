package com.versusmind.demo.core.domain.handlerBus;

import lombok.Builder;
import lombok.Getter;

import java.lang.reflect.Method;

@Builder
public class HandlerRegister {

    @Getter
    private Object classHandler;

    @Getter
    private Method methodHandler;

    @Getter
    private Class<?> trigger;
}

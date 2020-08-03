package com.versusmind.demo.core.domain.requestBus;

import lombok.Builder;
import lombok.Getter;

import java.lang.reflect.Method;

@Builder
public class RequestHandlerRegister {

    @Getter
    private Class<?> classHandler;

    @Getter
    private Method methodHandler;

    @Getter
    private Class<?> trigger;
}

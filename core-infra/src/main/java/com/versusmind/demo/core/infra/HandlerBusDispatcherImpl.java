package com.versusmind.demo.core.infra;

import com.versusmind.demo.core.domain.handlerBus.HandlerBusDispatcher;
import com.versusmind.demo.core.domain.handlerBus.HandlerRegister;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Component
public class HandlerBusDispatcherImpl implements HandlerBusDispatcher {

    private final Set<HandlerRegister> handlerBus = new HashSet<>();

    @Override
    public void register(HandlerRegister handlerRegister) {
        var handler = this.getHandler(handlerRegister.getTrigger());
        if (handler.isEmpty()) {
            this.handlerBus.add(handlerRegister);
            log.info("Handler Bus - New handler had : " + handlerRegister.getTrigger().getName());
        } else {
            log.error("Handler Bus - Trigger class " + handlerRegister.getTrigger().getName() + " don't implement a required interface or annotation");
        }
    }

    @Override
    public <R> R handle(Object trigger) {
        var handler = this.getHandler(trigger);

        if (handler.isPresent()) {
            var requestHandler = handler.get();
            Object classHandler = requestHandler.getClassHandler();
            Method method = requestHandler.getMethodHandler();
            try {
                return (R) method.invoke(classHandler, trigger);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public void unregister(Object trigger) {
        var handler = this.getHandler(trigger);
        handler.ifPresent(handlerBus::remove);
    }

    @Override
    public Optional<HandlerRegister> getHandler(Object h) {
        return handlerBus
                .stream()
                .filter(c -> c.getTrigger().getName().equals(h.getClass().getName()))
                .findFirst();
    }
}

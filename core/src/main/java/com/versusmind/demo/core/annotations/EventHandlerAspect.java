package com.versusmind.demo.core.annotations;

import com.versusmind.demo.core.handlers.HandlerRegister;
import com.versusmind.demo.core.handlers.events.Event;
import com.versusmind.demo.core.handlers.events.EventBusDispatcher;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;

@Slf4j
@Aspect
@Component
public class EventHandlerAspect implements BeanPostProcessor {

    @Autowired
    private EventBusDispatcher eventBusDispatcher;

    @Override
    public Object postProcessAfterInitialization(Object object, String beanName) {
        Class<?> clazz = object.getClass();

        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(EventHandler.class) && method.getParameterTypes().length == 1) {
                if (Arrays.stream(method.getParameterTypes()[0].getInterfaces()).noneMatch(c -> Objects.equals(c, Event.class))) {
                    log.error("EventHandler - params need to implement Query class ");
                } else {
                    String eventTypeName = method.getParameterTypes()[0].getTypeName();

                    HandlerRegister handlerRegister = HandlerRegister.builder()
                            .className(clazz.getTypeName())
                            .methodName(method.getName())
                            .typeName(eventTypeName)
                            .build();
                    eventBusDispatcher.registre(handlerRegister);
                }
            }
        }
        return object;
    }
}
package com.versusmind.demo.core.handlers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public abstract class HandlerBusDispatcherAbstract<E, R extends HandlerResponse> implements HandlerDispatcher<E, R> {
    @Autowired
    private AutowireCapableBeanFactory autowireCapableBeanFactory;

    private Map<String, HandlerRegister> eventHandlers = new HashMap<>();


    public void registre(HandlerRegister handler) {
        if (handler.isValid()) {
            if (!eventHandlers.containsKey(handler.getTypeName())) {
                eventHandlers.put(handler.getTypeName(), handler);
                log.info("EventBusDispatcher - new EventHandler registred : " + handler.getTypeName());
            } else {
                log.warn("EventBusDispatcher - an EventHandler exist for " + handler.getTypeName());
            }
        }
    }

    public R handle(E event) {
        var type = event.getClass().getTypeName();
        HandlerRegister eventHandler = eventHandlers.get(type);
        if (eventHandler == null) throw new RuntimeException("EventBusDispatcher - unknown service type: " + type);

        try {
            Class<?> c = Class.forName(eventHandler.getClassName());
            Method method = c.getMethod(eventHandler.getMethodName(), event.getClass());
            Constructor co = c.getDeclaredConstructor();
            co.setAccessible(true);
            Object o = co.newInstance();
            autowireCapableBeanFactory.autowireBean(o);
            return (R) method.invoke(o, event);

        } catch (Exception e) {
            log.error(e.getMessage());
            return (R) HandlerResponse.WithFault(e);
        }
    }
}

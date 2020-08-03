package com.versusmind.demo.core.infrastructure;

import com.versusmind.demo.core.domain.requestBus.RequestBusFactory;
import com.versusmind.demo.core.domain.requestBus.RequestHandlerRegister;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Slf4j
@Component
public class RequestBusFactoryImpl implements RequestBusFactory {

    @Autowired
    private AutowireCapableBeanFactory autowireCapableBeanFactory;

    @Getter
    private final Map<String, RequestHandlerRegister> busMap = new ConcurrentHashMap<>();

    @Setter
    private Class<?> requiredInterface = null;

    @Override
    public void register(RequestHandlerRegister handler) {
        if (interfaceTrigger(handler.getTrigger(), requiredInterface)) {
            log.error("Request Bus - New handler had : " + handler.getTrigger().getName());
            this.busMap.put(handler.getTrigger().getCanonicalName(), handler);
        } else {
            log.warn("Request Bus - Trigger class don't implement a required interface");
        }
    }

    @Override
    public <R> R handle(Object trigger) {
        var t = trigger.getClass().getCanonicalName();
        if (busMap.containsKey(t)) {
            var requestHandler = busMap.get(t);
            Class<?> handler = requestHandler.getClassHandler();
            Method method = requestHandler.getMethodHandler();
            try {
                Constructor co = handler.getDeclaredConstructor();
                co.setAccessible(true);
                Object o = co.newInstance();
                autowireCapableBeanFactory.autowireBean(o);
                return (R) method.invoke(o, trigger);
            } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | InstantiationException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public void unregister(Object trigger) {
        String currentClass = trigger.getClass().getCanonicalName();
        busMap.remove(currentClass);
    }

    private boolean interfaceTrigger(Class<?> trigger, Class<?> interfaceRequired) {
        if (interfaceRequired != null) {
            List<Class<?>> interfaces = getInterfaceInheritance(trigger);
            return interfaces.contains(interfaceRequired);
        }
        return true;
    }

    private List<Class<?>> getInterfaceInheritance(Class<?> in) {
        List<Class<?>> interfaces = Arrays.stream(in.getInterfaces()).collect(Collectors.toList());
        Arrays.stream(in.getInterfaces()).forEach(i -> interfaces.addAll(getInterfaceInheritance(i)));
        return interfaces;
    }
}

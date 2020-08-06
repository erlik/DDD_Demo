package com.versusmind.demo.core.domain.handlerBus.annotations;

import com.versusmind.demo.core.domain.handlerBus.HandlerBusDispatcher;
import com.versusmind.demo.core.domain.handlerBus.HandlerRegister;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Component
public class HandlerAnnotationPostProcessor implements BeanPostProcessor {

    @Autowired
    private HandlerBusDispatcher eventBus;

    @Override
    public Object postProcessAfterInitialization(Object object, String beanName) {
        Class<?> classHandler = object.getClass();
        Arrays.stream(classHandler.getDeclaredMethods()).forEach(method -> {
            if (method.isAnnotationPresent(Handler.class)) {
                if (method.getParameterCount() == 1) {
                    Class<?> parameter = method.getParameterTypes()[0];
                    HandlerRegister handlerRegister = HandlerRegister
                            .builder()
                            .classHandler(object)
                            .methodHandler(method)
                            .trigger(parameter)
                            .build();
                    eventBus.register(handlerRegister);
                } else {
                    log.error("EventHandler - params need to implement RequestWrapper interface ");
                }
            }
        });

        return object;
    }
}

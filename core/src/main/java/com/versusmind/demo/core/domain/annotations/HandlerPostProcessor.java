package com.versusmind.demo.core.domain.annotations;

import com.versusmind.demo.core.domain.requestBus.RequestHandlerRegister;
import com.versusmind.demo.core.infrastructure.RequestBusFactoryImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Component
public class HandlerPostProcessor implements BeanPostProcessor {

    @Autowired
    private RequestBusFactoryImpl eventBus;

    @Override
    public Object postProcessAfterInitialization(Object object, String beanName) {
        Class<?> classHandler = object.getClass();
        Arrays.stream(classHandler.getDeclaredMethods()).forEach(method -> {
            if (method.isAnnotationPresent(Handler.class)) {
                if (method.getParameterCount() == 1) {
                    Class<?> parameter = method.getParameterTypes()[0];
                    RequestHandlerRegister requestHandlerRegister = RequestHandlerRegister
                            .builder()
                            .classHandler(classHandler)
                            .methodHandler(method)
                            .trigger(parameter)
                            .build();

                    eventBus.register(requestHandlerRegister);
                } else {
                    log.error("EventHandler - params need to implement RequestWrapper interface ");
                }
            }
        });

        return object;
    }
}

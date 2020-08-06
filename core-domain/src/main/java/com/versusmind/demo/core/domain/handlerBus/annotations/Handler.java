package com.versusmind.demo.core.domain.handlerBus.annotations;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Handler {
    String value() default "";
}

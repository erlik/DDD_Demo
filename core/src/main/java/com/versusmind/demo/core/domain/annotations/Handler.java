package com.versusmind.demo.core.domain.annotations;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Handler {
    String value() default "";
}

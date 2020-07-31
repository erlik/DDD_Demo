package com.versusmind.demo.core.handlers;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.StringUtils;

@Builder
public class HandlerRegister {
    @Getter
    @Setter
    private String className;

    @Getter
    @Setter
    private String methodName = "handler";

    @Getter
    @Setter
    private String typeName;

    public boolean isValid() {
        return !StringUtils.isEmpty(this.className)
                && !StringUtils.isEmpty(this.methodName)
                && !StringUtils.isEmpty(this.typeName);
    }
}

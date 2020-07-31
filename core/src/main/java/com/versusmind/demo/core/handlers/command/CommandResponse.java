package com.versusmind.demo.core.handlers.command;

import com.versusmind.demo.core.handlers.HandlerResponse;

public class CommandResponse extends HandlerResponse {
    public static CommandResponse WithValue(Object value) {
        var response = new CommandResponse();
        return response;
    }

    public static CommandResponse WithoutValue() {
        return new CommandResponse();
    }

    public static CommandResponse WithFault(Exception fault) {
        var response = new CommandResponse();
        response.fault = fault;
        return response;
    }
}

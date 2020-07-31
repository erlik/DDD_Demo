package com.versusmind.demo.core.handlers.events;

import com.versusmind.demo.core.handlers.HandlerResponse;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;


public class EventResponse extends HandlerResponse {

    @Getter
    private List<Event> events;


    public static EventResponse WithValue(Object value) {
        var response = new EventResponse();
        response.value = value;
        return response;
    }

    public static EventResponse WithoutValue() {
        return new EventResponse();
    }

    public static EventResponse WithFault(Exception fault) {
        var response = new EventResponse();
        response.fault = fault;
        return response;
    }

    public static EventResponse WithValue(Object value, List<Event> events) {
        var response = new EventResponse();
        response.value = value;
        response.events = events;
        return response;
    }

    public static EventResponse WithoutValue(List<Event> events) {
        var response = new EventResponse();
        response.events = events;
        return response;
    }

    public static EventResponse WithFault(Exception fault, List<Event> events) {
        var response = new EventResponse();
        response.events = events;
        return response;
    }
}

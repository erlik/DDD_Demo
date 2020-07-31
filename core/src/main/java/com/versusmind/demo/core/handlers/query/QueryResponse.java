package com.versusmind.demo.core.handlers.query;

import com.versusmind.demo.core.handlers.HandlerResponse;
import lombok.Getter;

import java.util.List;

public class QueryResponse extends HandlerResponse {

    @Getter
    private List<Query> querys;

    private QueryResponse() {
    }

    public static QueryResponse WithValue(Object value, List<Query> querys) {
        var response = new QueryResponse();
        response.value = value;
        response.querys = querys;
        return response;
    }

    public static QueryResponse WithoutValue(List<Query> querys) {
        var response = new QueryResponse();
        response.querys = querys;
        return response;
    }

    public static QueryResponse WithFault(Exception fault, List<Query> querys) {
        var response = new QueryResponse();
        response.querys = querys;
        return response;
    }
}

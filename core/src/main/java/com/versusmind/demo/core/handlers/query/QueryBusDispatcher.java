package com.versusmind.demo.core.handlers.query;

import com.versusmind.demo.core.handlers.HandlerBusDispatcherAbstract;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class QueryBusDispatcher extends HandlerBusDispatcherAbstract<Query, QueryResponse> {

}

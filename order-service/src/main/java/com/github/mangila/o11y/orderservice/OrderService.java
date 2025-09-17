package com.github.mangila.o11y.orderservice;

import io.micrometer.observation.annotation.Observed;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class OrderService {
    @Observed(
            name = "order_created",             // metric name
            contextualName = "create_order",   // shows up in traces
            lowCardinalityKeyValues = {"operation", "mutation"}
    )
    public String createOrder() {
        log.info("Creating order");
        String id = UUID.randomUUID().toString();
        log.info("Order created with id {}", id);
        return id;
    }

    @Observed(
            name = "order_find",             // metric name
            contextualName = "find_order",   // shows up in traces
            lowCardinalityKeyValues = {"operation", "query"}
    )
    public Order findById(String id) {
        log.info("Getting order with id {}", id);
        var o = new Order("", "", List.of(), "", "", 0.0);
        log.info("Order found {}", o);
        return o;
    }
}

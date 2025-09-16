package com.github.mangila.o11y.orderservice;

import io.micrometer.core.annotation.Counted;
import io.micrometer.core.annotation.Timed;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class OrderService {

    @Counted(value = "order.counted.created")
    @Timed("order.timed.created")
    public String createOrder() {
        log.info("Creating order");
        String id = UUID.randomUUID().toString();
        log.info("Order created with id {}", id);
        return id;
    }

    @Counted(value = "order.counted.find")
    @Timed("order.timed.find")
    public Order findById(String id) {
        log.info("Getting order with id {}", id);
        var o = new Order("", "", List.of(), 0.0);
        log.info("Order found {}", o);
        return o;
    }
}

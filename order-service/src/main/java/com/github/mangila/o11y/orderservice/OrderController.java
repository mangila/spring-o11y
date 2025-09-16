package com.github.mangila.o11y.orderservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/order")
@Slf4j
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<?> createOrder() {
        log.info("Creating order");
        return ResponseEntity.ok("Order created");
    }

    @GetMapping
    public ResponseEntity<?> getOrder() {
        log.info("Getting order");
        return ResponseEntity.ok("Order");
    }

}

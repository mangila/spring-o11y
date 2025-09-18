package com.github.mangila.o11y.orderservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.micrometer.observation.annotation.Observed;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class OrderService {
    private final DeliveryServiceClient deliveryServiceClient;
    private final RabbitTemplate rabbitTemplate;
    private final MemoryDatabase memoryDatabase;
    private final ObjectMapper objectMapper;

    public OrderService(DeliveryServiceClient deliveryServiceClient,
                        RabbitTemplate rabbitTemplate,
                        MemoryDatabase memoryDatabase,
                        ObjectMapper objectMapper) {
        this.deliveryServiceClient = deliveryServiceClient;
        this.rabbitTemplate = rabbitTemplate;
        this.memoryDatabase = memoryDatabase;
        this.objectMapper = objectMapper;
    }

    @Observed(
            name = "order_created",
            lowCardinalityKeyValues = {"operation", "mutation"}
    )
    public String createOrder() {
        log.trace("Creating order");
        String id = UUID.randomUUID().toString();
        Order order = new Order(id,
                UUID.randomUUID().toString(),
                List.of(),
                "Street 123",
                "IN_PROGRESS",
                2.0);
        rabbitTemplate.convertAndSend(Config.NEW_ORDER_TO_DELIVERY_QUEUE, objectMapper.createObjectNode()
                .put("id", order.id())
                .put("address", order.address())
                .toString());
        memoryDatabase.save(order);
        log.trace("Order created with id {}", id);
        return id;
    }

    @Observed(
            name = "order_find",
            lowCardinalityKeyValues = {"operation", "query"}
    )
    public Order findById(String id) {
        log.trace("Getting order with id {}", id);
        Order order = memoryDatabase.findById(id);
        if (order != null) {
            log.trace("Order found {}", order);
            return order;
        }
        throw new RuntimeException("Order not found");
    }
}

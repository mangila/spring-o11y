package com.github.mangila.o11y.deliveryservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderListener {

    @RabbitListener(
            queues = "new-order-to-delivery-queue",
            containerFactory = "rabbitListenerContainerFactory",
            executor = "applicationTaskExecutor" // run in a Virtual Thread
    )
    public void listen(String s) {
        log.info("Received message: {}", s);
    }

}

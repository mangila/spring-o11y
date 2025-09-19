package com.github.mangila.o11y.deliveryservice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/delivery")
public class DeliveryController {

    private final DeliveryService deliveryService;

    public DeliveryController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @GetMapping("{orderId}")
    public ResponseEntity<String> getDelivery(@PathVariable String orderId) {
        String deliveryJson = deliveryService.getDelivery(orderId);
        if (deliveryJson.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(deliveryJson);
    }

    @PostMapping("{orderId}")
    public ResponseEntity<?> fullFillDelivery(@PathVariable String orderId) {
        boolean result = deliveryService.fullFill(orderId);
        if (!result) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }

}

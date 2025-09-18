package com.github.mangila.o11y.deliveryservice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/delivery")
public class DeliveryController {


    @PostMapping
    public ResponseEntity<String> createDelivery() {
        return ResponseEntity.ok("OK");
    }

    @GetMapping
    public ResponseEntity<String> getDeliveryStatus() {
        return ResponseEntity.ok("OK");
    }

}

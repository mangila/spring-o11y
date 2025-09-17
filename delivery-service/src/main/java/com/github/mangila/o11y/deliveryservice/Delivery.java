package com.github.mangila.o11y.deliveryservice;

public record Delivery(String orderId,
                       String address,
                       String status) {
}

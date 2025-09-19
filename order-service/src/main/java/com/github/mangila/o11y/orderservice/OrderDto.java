package com.github.mangila.o11y.orderservice;

import java.util.List;

public record OrderDto(
        String customerId,
        List<String> items,
        String address,
        String status,
        double price
) {
}

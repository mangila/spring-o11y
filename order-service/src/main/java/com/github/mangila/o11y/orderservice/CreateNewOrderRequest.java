package com.github.mangila.o11y.orderservice;

import java.util.List;

public record CreateNewOrderRequest(
        String customerId,
        List<String> items,
        String address
) {
}

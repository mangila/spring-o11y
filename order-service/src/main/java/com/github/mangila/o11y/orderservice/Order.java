package com.github.mangila.o11y.orderservice;

import java.util.List;

public record Order(String id,
                    String customerId,
                    List<String> items,
                    double price) {
}

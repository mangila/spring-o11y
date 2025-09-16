package com.github.mangila.o11y.orderservice;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class DeliveryServiceClient {
    private final RestClient restClient;

    public DeliveryServiceClient(@Qualifier("deliveryRestClient") RestClient restClient) {
        this.restClient = restClient;
    }
}

package com.github.mangila.o11y.orderservice;

import io.micrometer.observation.annotation.Observed;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
@Observed(name = "delivery-service-client")
public class DeliveryServiceClient {
    private final RestClient restClient;
    private final String basePath;

    public DeliveryServiceClient(@Qualifier("deliveryRestClient") RestClient restClient,
                                 @Value("${application.integration.delivery-service.basepath}") String basePath) {
        this.restClient = restClient;
        this.basePath = basePath;
    }

    public String getDeliveryStatus() {
        return restClient.get()
                .uri(basePath)
                .retrieve()
                .body(String.class);
    }

    public void createDelivery(String id, String address) {
        restClient.post()
                .uri(uriBuilder -> uriBuilder.path(basePath)
                        .queryParam("id", id)
                        .queryParam("address", address)
                        .build())
                .retrieve()
                .toBodilessEntity();
    }
}

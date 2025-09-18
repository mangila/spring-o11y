package com.github.mangila.o11y.orderservice;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.config.NamingConvention;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;

@Configuration
public class Config {

    @Bean
    public Queue newOrderDeliveryQueue() {
        return new Queue("new-order-delivery", Boolean.FALSE);
    }

    @Bean
    RestClient deliveryRestClient(
            @Value("${spring.application.name}") String applicationName,
            @Value("${application.integration.delivery-service.url}") String url) {
        return RestClient.builder()
                .baseUrl(url)
                .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.USER_AGENT, applicationName)
                .build();
    }

    @Bean
    MeterRegistryCustomizer<MeterRegistry> customizer() {
        return registry -> {
            registry.config().namingConvention(NamingConvention.snakeCase);
        };
    }
}

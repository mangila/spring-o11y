package com.github.mangila.o11y.orderservice;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.config.NamingConvention;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;

@Configuration
public class Config {

    @Bean
    RestClient deliveryRestClient() {
        return RestClient.builder()
                .baseUrl("http://localhost:8081")
                .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.USER_AGENT, "Order-Service")
                .build();
    }

    @Bean
    MeterRegistryCustomizer<MeterRegistry> customizer() {
        return registry -> {
            registry.config().namingConvention(NamingConvention.snakeCase);
        };
    }
}

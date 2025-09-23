package com.github.mangila.o11y.deliveryservice;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.config.NamingConvention;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.core.task.VirtualThreadTaskExecutor;

@Configuration
public class Config {

    @Bean
    MeterRegistryCustomizer<MeterRegistry> customizer() {
        return registry -> {
            registry.config().namingConvention(NamingConvention.snakeCase);
        };
    }

    @Bean
    TaskExecutor rabbitListenerExecutor() {
        return new VirtualThreadTaskExecutor("rabbitmq-listener-");
    }
}

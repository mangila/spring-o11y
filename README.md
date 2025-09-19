# spring-o11y

Spring boot web application demonstrating usage with OTel-collector to route to different o11y backends

Design for Observability

Fulfilling the three pillars of observability:

- Logs
- Metrics
- Traces

# How to run

- Start the infra (docker-compose) located in /infrastructure
- Start the applications
- Send some requests via .http files located in /http

## o11y backends

OTel-collector is configured to route to

- Loki (Logs)-localhost:3100
- Prometheus (Metrics)—localhost:9090
- Zipkin (Traces)—localhost:9411
- File (debugging purposes)

## Visualisation

Grafana is provisioned with the datasource and dashboards to visualize the data.

- Grafana-localhost:3000
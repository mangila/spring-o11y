# spring-o11y

Spring boot web application demonstrating usage with OTel-collector to route to different o11y backends

to start everything, run the docker-compose file located in /infrastructure

## o11y backends

OTel-collector is configured to route to, fulfilling the three pillars of observability:

- Loki (Logs)-localhost:3100
- Prometheus (Metrics)—localhost:9090
- Zipkin (Traces)—localhost:9411
- File (debugging purposes)

## Visualisation

Grafana is provisioned with the datasource and dashboards to visualize the data.

- Grafana-localhost:3000
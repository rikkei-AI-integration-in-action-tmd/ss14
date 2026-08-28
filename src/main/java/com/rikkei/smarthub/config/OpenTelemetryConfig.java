package com.rikkei.smarthub.config;

import io.micrometer.tracing.Tracer;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenTelemetryConfig {

    private final Tracer tracer;

    public OpenTelemetryConfig(Tracer tracer) {
        this.tracer = tracer;
    }

    public Tracer getTracer() {
        return tracer;
    }
}

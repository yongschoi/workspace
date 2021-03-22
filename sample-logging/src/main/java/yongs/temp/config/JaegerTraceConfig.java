package yongs.temp.config;

import io.jaegertracing.internal.JaegerTracer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by yogschoi@gmail.com on 2020-11-25
 * Github : http://github.com/yogschoi
 */
@Slf4j
@ConditionalOnProperty(value = "opentracing.jaeger.enabled", havingValue = "false", matchIfMissing = false)
@Configuration
public class JaegerTraceConfig {
    @Value("${spring.application.name}")
    private String appName;
    @Bean
    public io.opentracing.Tracer jaegerTracer() {
        return new JaegerTracer.Builder(appName).build();
    }
}
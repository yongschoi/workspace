package yongs.temp.controller;

import io.opentracing.Span;
import io.opentracing.Tracer;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yogschoi@gmail.com on 2020-11-24
 * Github : http://github.com/yogschoi
 */
@Slf4j
@RestController
public class HelloController {
    @Value("${spring.application.name}")
    private String appName;
    @Autowired
    private Tracer trace;

    @GetMapping("/hello")
    public String hello() throws Exception {
        // MDC.put("test", "test입니다."); // interceptor로 처리
        Span span = trace.activeSpan();
        String traceId = span.context().toTraceId();
        String spanId = span.context().toSpanId();
        MDC.put("traceId", traceId);
        MDC.put("spanId", spanId);

        log.debug("이거슨 debug 로그입니다." + appName);
        // log.info("이거슨 info 로그입니다.");

        return "Hello";
    }
}

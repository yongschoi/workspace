package yongs.temp.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

/**
 * Created by yogschoi@gmail.com on 2020-11-28
 * Github : http://github.com/yogschoi
 */
@Slf4j
@Aspect
@Component
public class TimeCheck {
    // @Around("execution(* yongs.temp.service.ConsumerCoffeeService.*(..))")
    public Object elapsed(ProceedingJoinPoint point) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Object result = point.proceed();
        stopWatch.stop();
        log.info("수행시간 >>> {}", stopWatch.getTotalTimeSeconds());
        return result;
    }
}


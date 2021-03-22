package yongs.temp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by yogschoi@gmail.com on 2020-11-26
 * Github : http://github.com/yogschoi
 */
@SpringBootApplication
public class ConsumerConcurrencyApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerConcurrencyApplication.class, args);
    }
}
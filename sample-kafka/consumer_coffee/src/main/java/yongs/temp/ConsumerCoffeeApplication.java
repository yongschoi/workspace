package yongs.temp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by yogschoi@gmail.com on 2020-11-26
 * Github : http://github.com/yogschoi
 */
@EnableAspectJAutoProxy
@SpringBootApplication
public class ConsumerCoffeeApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerCoffeeApplication.class, args);
    }
}
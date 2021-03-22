package yongs.temp.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import yongs.temp.vo.Coffee;

import java.time.LocalDate;
import java.util.stream.IntStream;

/**
 * Created by yogschoi@gmail.com on 2020-11-26
 * Github : http://github.com/yogschoi
 */
@SpringBootTest
public class CoffeeProducerServiceTest {
    @Autowired
    CoffeeProducerService service;

    @Test
    public void Kafka_Coffee_메시지전송() {
        IntStream.rangeClosed(1, 10000).forEach(i -> {
            service.sendCoffee(new Coffee("양구"+i, 2500, LocalDate.now()));
        });
    }
}

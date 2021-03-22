package yongs.temp.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import yongs.temp.vo.Coffee;

import java.util.List;

/**
 * Created by yogschoi@gmail.com on 2020-11-26
 * Github : http://github.com/yogschoi
 */
@Slf4j
@Service
public class ConsumerConcurrencyService {
    // for receiver
    private static final String RECEIVE_EVT = "coffee";

    @KafkaListener(topics = RECEIVE_EVT, containerFactory = "concurrencyFactory")
    public void receiveCoffee(List<Coffee> coffee) {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info(coffee.toString());
    }
}

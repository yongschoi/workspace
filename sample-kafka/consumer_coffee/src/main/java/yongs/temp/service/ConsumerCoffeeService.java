package yongs.temp.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;
import yongs.temp.vo.Coffee;

import java.util.List;

/**
 * Created by yogschoi@gmail.com on 2020-11-26
 * Github : http://github.com/yogschoi
 */
@Slf4j
@Service
public class ConsumerCoffeeService {
    // for receiver
    private static final String RECEIVE_EVT = "coffee";

    @KafkaListener(topics = RECEIVE_EVT, containerFactory = "singleFactory")
    public void receiveCoffee(Coffee coffee) {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info(coffee.toString());
    }
}

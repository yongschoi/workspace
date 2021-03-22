package yongs.temp.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import yongs.temp.vo.Coffee;
import yongs.temp.vo.Member;

import java.util.List;

/**
 * Created by yogschoi@gmail.com on 2020-11-26
 * Github : http://github.com/yogschoi
 */
@Slf4j
@Service
public class CoffeeProducerService {
    // for sender
    private static final String SEND_EVT = "coffee";
    @Autowired
    ObjectMapper mapper;

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;
    @Autowired
    KafkaTemplate<String, Coffee> coffeeKafkaTemplate;

    public void sendString(Coffee coffee) throws JsonProcessingException {
        // Consumer max.request.size = 1M
        String coffeeStr = mapper.writeValueAsString(coffee);
        kafkaTemplate.send(SEND_EVT, coffeeStr);
    }

    public void sendCoffee(Coffee coffee) {
        // Consumer max.request.size = 1M
        coffeeKafkaTemplate.send(SEND_EVT, coffee);
    }
}

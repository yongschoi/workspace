package yongs.temp.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.Message;
import yongs.temp.vo.Coffee;
import yongs.temp.vo.Member;

import java.time.LocalDate;
import java.util.stream.IntStream;

/**
 * Created by yogschoi@gmail.com on 2020-11-26
 * Github : http://github.com/yogschoi
 */
@SpringBootTest
public class TypeProducerServiceTest {
    private static final String SEND_EVT = "member";
    @Autowired
    KafkaTemplate<String, Member> memberKafkaTemplate;

    @Test
    public void Kafka_범용Tyep_메시지전송() {
        IntStream.rangeClosed(1, 10).forEach(i -> {
            memberKafkaTemplate.send(SEND_EVT, new Member("양구"+i, "2500", LocalDate.now()));
        });
    }
}

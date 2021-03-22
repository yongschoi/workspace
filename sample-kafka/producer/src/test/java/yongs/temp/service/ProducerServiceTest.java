package yongs.temp.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import yongs.temp.vo.Member;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yogschoi@gmail.com on 2020-11-26
 * Github : http://github.com/yogschoi
 */
@SpringBootTest
public class ProducerServiceTest {
    @Autowired
    ProducerService service;

    @Test
    public void Kafka_기본_메시지전송() throws JsonProcessingException {
        for (int i = 0; i < 10; i++) {
            service.memberInfo(new Member("A"+i, "길동"+i, LocalDate.now()));
        }
    }

    @Test
    public void Kafka_멀티_메시지전송() throws JsonProcessingException {
        List<Member> list = new ArrayList<Member>();
        for (int i = 0; i < 10; i++) {
            list.add(new Member("GILL"+i, "길동"+i, LocalDate.now()));
        }
        service.members(list);
    }
}

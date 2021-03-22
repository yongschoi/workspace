package yongs.temp.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;
import yongs.temp.vo.Member;

import java.util.List;

/**
 * Created by yogschoi@gmail.com on 2020-11-26
 * Github : http://github.com/yogschoi
 */
@Slf4j
@Service
public class ConsumerTypeService {
    // for receiver
    private static final String MEMBER_RECEIVE = "member";

    @KafkaListener(topics = MEMBER_RECEIVE)
    public void member(Member member) {
        log.debug("ConsumerService.memberInfo(" + member.toString() + ")");
        // ack.acknowledge()는 rollback을 허용 하지 않고 반드시 처리하겠다는 의미임.
    }
}

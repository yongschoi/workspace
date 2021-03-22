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
import yongs.temp.vo.Member;

import java.util.List;

/**
 * Created by yogschoi@gmail.com on 2020-11-26
 * Github : http://github.com/yogschoi
 */
@Slf4j
@Service
public class ProducerService {
    // for sender
    private static final String SEND_EVT = "producer-consumer-member";
    private static final String MEMBERS_SEND_EVT = "producer-consumer-members";

    @Autowired
    ObjectMapper mapper;
    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    public void members(List<Member> members) throws JsonProcessingException{
        // Consumer max.request.size = 1M
        String memberStr = mapper.writeValueAsString(members);
        kafkaTemplate.send(MEMBERS_SEND_EVT, memberStr);
    }

    public void memberInfo(Member member) throws JsonProcessingException{
        String memberStr = mapper.writeValueAsString(member);
        // to consumer
        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(SEND_EVT, memberStr);

        // 처리값을 확인할 수 있지만, Thread가 waiting해서 Product의 성능이 저하될 수 있다.(성능상 의미없는 코드)
        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            // topic 알파벳 오류가 발생해도 그냥 보내고 onSuccess가 수행된다.
            @Override
            public void onSuccess(SendResult<String, String> result) {
                log.info("Sent message=[" + memberStr + "] with offset=[" + result.getRecordMetadata().offset() + "]");
            }
            // kafka가 죽어야 onFailure 수행된다.
            @Override
            public void onFailure(Throwable ex) {
                log.error("Unable to send message=[" + memberStr + "] due to : " + ex.getMessage());
            }
        });
    }
}

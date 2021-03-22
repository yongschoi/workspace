package cj.enmframework.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import cj.enmframework.model.OutBoxEntity;
import cj.enmframework.service.OutBoxService;
import lombok.extern.slf4j.Slf4j;

/**
 * <pre>
 * Copyright (c) 2021 CJ OliveNetworks
 * All rights reserved.
 * 
 * This software is the proprietary information of CJ OliveNetworks
 * </pre> 
 *
 * @author yschoi21
 * @since 2021. 2. 8.
 *
 * @History
 * <pre>
 * --------------------------------------------------------------
 * 2021. 2. 8. yschoi21(yschoi21@cj.net) 최초작성
 * --------------------------------------------------------------
 * </pre>
 */
@Slf4j
@Component
public class KafkaMessageRelayer {
	@Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
	@Autowired
	private OutBoxService outBoxService;
	
	public void relayMessage(OutBoxEntity box) {
		ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(box.getTopic(), box.getPayload());
		
		future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            // topic 알파벳 오류가 발생해도 그냥 보내고 onSuccess가 수행된다.
            @Override
            public void onSuccess(SendResult<String, String> result) {
                log.debug("Sent message=[" + box.getId() + "===>" + box.getPayload() + "] with offset=[" + result.getRecordMetadata().offset() + "]");
                // 보내기 성공이면 해당 메시지를 outbox db에서 삭제한다.
                outBoxService.complete(box);
            }
            // kafka가 죽어야 onFailure 수행된다.
            @Override
            public void onFailure(Throwable ex) {
                log.error("Unable to send message=[" + box.getId() + "===>" + box.getPayload() + "] due to : " + ex.getMessage());
                outBoxService.rollback(box);
            }
        });	
	}
}
